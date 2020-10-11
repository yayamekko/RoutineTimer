package com.yayame.routinetimer.realm

import android.content.Context
import com.yayame.routinetimer.realmobject.RoutineTaskItemRealmObject
import io.realm.Realm
import io.realm.RealmConfiguration
import java.util.*

class RealmUtil {

    lateinit var realm: Realm

    fun close() {
        realm.close()
    }

    fun createRoutineTaskItem(
        taskGroupId: String,
        taskName: String,
        timeMillis: Long
    ) {
        createRoutineTaskItemRealmObject(
            UUID.randomUUID().toString(),
            taskGroupId,
            getSequenceNumberOfTaskItem(taskGroupId),
            taskName,
            timeMillis
        )
    }

    private fun createRoutineTaskItemRealmObject(
        taskId: String,
        taskGroupId: String,
        sequenceNumber: Int,
        taskName: String,
        timeMillis: Long
    ) {
        realm.executeTransaction {
            val routineTaskItem = realm.createObject(RoutineTaskItemRealmObject::class.java)
            routineTaskItem.also {
                it.taskId = taskId
                it.taskGroupId = taskGroupId
                it.sequenceNumber = sequenceNumber
                it.taskName = taskName
                it.timeMillis = timeMillis
            }
            realm.copyToRealm(routineTaskItem)
        }
    }

    private fun getSequenceNumberOfTaskItem(taskGroupId: String): Int {
        val sequenceNumber = realm.where(RoutineTaskItemRealmObject::class.java)
            .equalTo("taskGroupId", taskGroupId)
            .max("sequenceNumber")

        return sequenceNumber?.toInt()?.plus(1) ?: 0
    }

    fun initRealm(context: Context) {
        Realm.init(context)
        val config = RealmConfiguration.Builder()
            .name("RoutineTimer.realm")
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(config)
        realm = Realm.getDefaultInstance()
    }
}