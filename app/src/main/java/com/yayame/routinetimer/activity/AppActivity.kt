package com.yayame.routinetimer.activity

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.yayame.routinetimer.R
import com.yayame.routinetimer.util.functionActionHandler

class AppActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = "Routine Timer"
        setSupportActionBar(toolbar)
        // TODO どっかにうつしたい
        functionActionHandler().showRoutineListFragment(this)
    }

    // フラグメントを追加する
    fun addFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction();
        transaction.add(R.id.import_fragment_area, fragment)
        transaction.commit();
    }
}
