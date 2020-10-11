package com.yayame.routinetimer.realmobject

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required


open class RoutineTaskGroupRealmObject : RealmObject() {
    @PrimaryKey
    private var taskGroupId: Int = -1

    private var sequenceNumber: Int = -1

    @Required
    private var taskGroupName: String = ""
}