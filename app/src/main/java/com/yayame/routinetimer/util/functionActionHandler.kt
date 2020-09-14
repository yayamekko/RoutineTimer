package com.yayame.routinetimer.util

import android.app.Activity
import com.yayame.routinetimer.activity.AppActivity
import com.yayame.routinetimer.ui.routineList.RoutineListFragment

class functionActionHandler {

    // fragmentから呼び出す処理
    fun showRoutineListFragment(activity: Activity) {
        val fragment = RoutineListFragment()
        // アクティビティにフラグメントを追加する
        if (activity is AppActivity) {
            activity.addFragment(fragment)
        }
    }
}