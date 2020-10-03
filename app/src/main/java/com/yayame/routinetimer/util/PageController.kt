package com.yayame.routinetimer.util

import android.app.Activity
import androidx.annotation.IdRes
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.yayame.routinetimer.R
import com.yayame.routinetimer.activity.AppActivity

class PageController(
    @IdRes private val importArea: Int
) {

    fun replaceFragment(fragmentTransaction: FragmentTransaction, fragment: Fragment) {
        fragmentTransaction.replace(importArea, fragment)
        fragmentTransaction.commit();
    }

    fun showDialogFragment(fragmentTransaction: FragmentTransaction, fragment: DialogFragment) {
        fragment.show(fragmentTransaction, fragment.javaClass.name)
    }

    companion object {
        @JvmStatic
        fun create(activity: Activity): PageController {
            val importArea = when (activity::class.java.name) {
                AppActivity::class.java.name -> R.id.import_fragment_area
                else -> 0
            }
            return PageController(importArea)
        }
    }
}