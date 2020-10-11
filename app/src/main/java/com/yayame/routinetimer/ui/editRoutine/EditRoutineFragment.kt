package com.yayame.routinetimer.ui.editRoutine

import android.app.Activity
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.yayame.routinetimer.R
import com.yayame.routinetimer.activity.AppActivity
import com.yayame.routinetimer.ui.common.SelectTimeDialogFragment

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.routine_task_time)
            .setOnClickListener {
                if (activity is AppActivity) {
                    activity.showFragment(SelectTimeDialogFragment.newInstance())
                }
            }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity.title = getString(R.string.edit_routine_title)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.edit_routine_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.edit_routine_save) {
            (activity as AppActivity).realmUtil.createRoutineTaskItem(
                "111",
                "手洗い",
                12345
            )
        }

        return true
    }

    companion object {
        @JvmStatic
        fun create(activity: Activity) = EditRoutineFragment(activity)
    }
}