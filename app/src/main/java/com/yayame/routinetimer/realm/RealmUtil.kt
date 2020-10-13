package com.yayame.routinetimer.realm

import android.content.Context
import android.util.Log
import com.facebook.stetho.Stetho
import com.uphyca.stetho_realm.RealmInspectorModulesProvider
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
            val routineTaskItem = realm.createObject(RoutineTaskItemRealmObject::class.java, taskId)
            routineTaskItem.also {
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

    fun initRealm(context: Context): RealmUtil {
        Realm.init(context)
        val config = RealmConfiguration.Builder()
            .name("RoutineTimer.realm")
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(config)
        realm = Realm.getDefaultInstance()
        Log.d("realm name :", realm.configuration.realmFileName)
        Stetho.initialize(
            Stetho.newInitializerBuilder(context)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(context))
                .enableWebKitInspector(RealmInspectorModulesProvider.builder(context).build())
                .build()
        )
        return this
    }
}