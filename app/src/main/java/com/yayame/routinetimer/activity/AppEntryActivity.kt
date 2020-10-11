package com.yayame.routinetimer.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yayame.routinetimer.realm.RealmUtil

class AppEntryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        RealmUtil().initRealm(this)
        startActivity(Intent(this, MainActivity::class.java))
    }
}
