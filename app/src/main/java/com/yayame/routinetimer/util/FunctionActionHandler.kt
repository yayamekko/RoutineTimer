package com.yayame.routinetimer.util

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class FunctionActionHandler(
    private val pageController: PageController
) {

    fun showFragment(transaction: FragmentTransaction, fragment: Fragment) {
        pageController.addFragment(transaction, fragment)
    }

    companion object {
        @JvmStatic
        fun create(
            activity: Activity
        ): FunctionActionHandler {
            return FunctionActionHandler(PageController.create(activity))
        }
    }
}