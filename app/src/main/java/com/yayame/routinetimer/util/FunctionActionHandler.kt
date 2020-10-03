package com.yayame.routinetimer.util

import android.app.Activity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class FunctionActionHandler(
    private val pageController: PageController
) {

    fun showFragment(transaction: FragmentTransaction, fragment: Fragment) {
        pageController.replaceFragment(transaction, fragment)
    }
    
    fun showDialogFragment(transaction: FragmentTransaction, fragment: DialogFragment) {
        pageController.showDialogFragment(transaction, fragment)
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