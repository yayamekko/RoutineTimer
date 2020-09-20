package com.yayame.routinetimer.util

import android.app.Activity
import androidx.fragment.app.FragmentTransaction
import com.yayame.routinetimer.ui.routineList.RoutineListFragment

class FunctionActionHandler(
    private val pageController: PageController
) {

    // fragmentから呼び出す処理
    fun showRoutineListFragment(fragment: RoutineListFragment) {
        pageController.addFragment(fragment)
    }

    companion object {
        @JvmStatic
        fun create(
            activity: Activity,
            fragmentTransaction: FragmentTransaction
        ): FunctionActionHandler {
            return FunctionActionHandler(PageController.create(activity, fragmentTransaction))
        }
    }
}