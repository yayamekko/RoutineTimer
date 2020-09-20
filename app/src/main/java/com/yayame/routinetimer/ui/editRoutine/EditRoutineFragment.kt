package com.yayame.routinetimer.ui.editRoutine

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yayame.routinetimer.R

class EditRoutineFragment(
    private val activity: Activity
) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_setting_routine, container, false)
    }

    companion object {
        @JvmStatic
        fun create(activity: Activity) = EditRoutineFragment(activity)
    }
}