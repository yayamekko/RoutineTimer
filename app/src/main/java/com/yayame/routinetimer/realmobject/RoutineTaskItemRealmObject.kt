package com.yayame.routinetimer.realmobject

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required


open class RoutineTaskItemRealmObject : RealmObject() {
    @PrimaryKey
    private var taskId: Int = -1

    private var taskGroupId: Int = -1

    private var sequenceNumber: Int = -1

    @Required
    private var taskName: String = ""

    private var timeMillis: Long = -1
}