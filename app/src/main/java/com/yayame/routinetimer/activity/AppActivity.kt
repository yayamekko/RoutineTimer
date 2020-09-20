package com.yayame.routinetimer.activity

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.yayame.routinetimer.R
import com.yayame.routinetimer.ui.routineList.RoutineListFragment
import com.yayame.routinetimer.util.FunctionActionHandler

class AppActivity(
) : BaseActivity() {

    private lateinit var functionActionHandler: FunctionActionHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)

        // ツールバーを設定
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = "Routine Timer"
        setSupportActionBar(toolbar)

        // フラグメントを設定
        functionActionHandler =
            FunctionActionHandler.create(this, supportFragmentManager.beginTransaction())
        functionActionHandler.showRoutineListFragment(RoutineListFragment.create(this))
    }

    companion object {
        fun create() {
            AppActivity()
        }
    }
}
