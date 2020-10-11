package com.yayame.routinetimer.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.yayame.routinetimer.R
import com.yayame.routinetimer.common.FunctionActionHandler
import com.yayame.routinetimer.realm.RealmUtil
import com.yayame.routinetimer.ui.routineList.RoutineListFragment

class AppActivity(
) : AppCompatActivity() {

    lateinit var functionActionHandler: FunctionActionHandler
    lateinit var realmUtil: RealmUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)
        realmUtil = RealmUtil().initRealm(this)

        // ツールバーを設定
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // フラグメントを設定
        functionActionHandler =
            FunctionActionHandler.create(this)
        showFragment(RoutineListFragment.create(this))
    }

    override fun onDestroy() {
        super.onDestroy()
        realmUtil.close()
    }

    fun showFragment(fragment: Fragment) {
        if (fragment is DialogFragment) {
            functionActionHandler.showDialogFragment(
                supportFragmentManager.beginTransaction(),
                fragment
            )
        } else {
            functionActionHandler.showFragment(supportFragmentManager.beginTransaction(), fragment)
        }

    }

    companion object {
        fun create() {
            AppActivity()
        }
    }
}
