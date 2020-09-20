package com.yayame.routinetimer.ui.routineList

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yayame.routinetimer.R
import com.yayame.routinetimer.activity.AppActivity
import com.yayame.routinetimer.model.RoutineTaskItem
import com.yayame.routinetimer.ui.editRoutine.EditRoutineFragment

class RoutineListFragment(
    private val activity: Activity
) : Fragment() {

    private lateinit var routineTaskRecyclerView: RecyclerView
    private lateinit var routineTaskAdapter: RecyclerView.Adapter<RoutineTaskViewHolder>
    private lateinit var routineTaskManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_routine_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val routineTaskItems = mutableListOf<RoutineTaskItem>()
        setRoutineTaskItems(routineTaskItems)

        val context = activity as? Context ?: return
        routineTaskAdapter =
            RoutineTaskAdapter(
                context,
                routineTaskItems
            )

        routineTaskManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        routineTaskRecyclerView = view.findViewById(R.id.routine_task)
        routineTaskRecyclerView.layoutManager = routineTaskManager
        routineTaskRecyclerView.adapter = routineTaskAdapter

        if (routineTaskAdapter is RoutineTaskAdapter) {
            (routineTaskAdapter as RoutineTaskAdapter)
                .setOnTaskClickListener(object : RoutineTaskAdapter.OnTaskClickListener {
                    override fun onTaskClickListener() {
                        if (activity is AppActivity) {
                            activity.showFragment(
                                EditRoutineFragment.create(activity)
                            )
                        }
                    }
                })
        }
    }

    fun setRoutineTaskItems(routineTaskItems: MutableList<RoutineTaskItem>) {
        for (i in 0..3) {
            val routineTaskItem =
                RoutineTaskItem(
                    i,
                    "task$i",
                    10
                )
            routineTaskItems.add(routineTaskItem)
        }
    }

    companion object {
        @JvmStatic
        fun create(activity: Activity) = RoutineListFragment(activity)
    }
}