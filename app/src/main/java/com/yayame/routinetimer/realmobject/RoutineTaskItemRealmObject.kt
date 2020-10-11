package com.yayame.routinetimer.realmobject

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required


open class RoutineTaskItemRealmObject(
    @PrimaryKey
    open var taskId: String = "",

    open var taskGroupId: String = "",

    open var sequenceNumber: Int = -1,

    @Required
    open var taskName: String = "",

    open var timeMillis: Long = -1
) : RealmObject()