package com.yayame.routinetimer.util

import android.app.Activity
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.yayame.routinetimer.R
import com.yayame.routinetimer.activity.AppActivity

class PageController(
    private val fragmentTransaction: FragmentTransaction,
    @IdRes private val importArea: Int
) {

    fun addFragment(fragment: Fragment) {
        fragmentTransaction.add(importArea, fragment)
        fragmentTransaction.commit();
    }

    companion object {
        @JvmStatic
        fun create(activity: Activity, fragmentTransaction: FragmentTransaction): PageController {
            val importArea = when (activity::class.java.name) {
                AppActivity::class.java.name -> R.id.import_fragment_area
                else -> 0
            }
            return PageController(fragmentTransaction, importArea)
        }
    }
}