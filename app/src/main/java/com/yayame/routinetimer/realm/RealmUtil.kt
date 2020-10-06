package com.yayame.routinetimer.realm

import android.content.Context
import io.realm.Realm
import io.realm.RealmConfiguration

class RealmUtil {

    fun insertRoutine() {
        val realm = Realm.getDefaultInstance() // opens "myrealm.realm"

        try {
            // ... Do something ...
        } finally {
            realm.close()
        }
    }


    companion object {
        fun init(context: Context) {
            Realm.init(context)
            val config = RealmConfiguration.Builder().name("RoutineTimer.realm").build()
            Realm.setDefaultConfiguration(config)
        }
    }
}