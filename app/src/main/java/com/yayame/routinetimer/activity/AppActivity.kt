package com.yayame.routinetimer.activity

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.yayame.routinetimer.R
import com.yayame.routinetimer.ui.routineList.RoutineListFragment
import com.yayame.routinetimer.util.FunctionActionHandler

class AppActivity(
) : BaseActivity() {

    lateinit var functionActionHandler: FunctionActionHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)

        // ツールバーを設定
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = "Routine Timer"
        setSupportActionBar(toolbar)

        // フラグメントを設定
        functionActionHandler =
            FunctionActionHandler.create(this)
        showFragment(RoutineListFragment.create(this))
    }

    fun showFragment(fragment: Fragment) {
        functionActionHandler.showFragment(supportFragmentManager.beginTransaction(), fragment)
    }

    companion object {
        fun create() {
            AppActivity()
        }
    }
}
