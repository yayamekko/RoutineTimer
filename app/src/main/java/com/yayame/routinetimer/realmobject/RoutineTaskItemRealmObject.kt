package com.yayame.routinetimer.realmobject

import io.realm.MutableRealmInteger
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required


class RoutineTaskItemRealmObject : RealmObject() {
    @PrimaryKey
    private var taskId: Int = -1

    private var taskGroupId: Int = -1
    
    private var sequenceNumber: MutableRealmInteger = MutableRealmInteger.valueOf(0)

    @Required
    private var taskName: String = ""

    private var timeMillis: Long = -1
}