package com.yayame.routinetimer.activity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yayame.routinetimer.R
import model.RoutineTaskItem

class RoutineTaskAdapter(private val routineTaskItems: List<RoutineTaskItem>) :
    RecyclerView.Adapter<RoutineTaskViewHolder>() {

    override fun getItemCount(): Int {
        return routineTaskItems.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoutineTaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.routine_task, parent, false)
        return RoutineTaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: RoutineTaskViewHolder, position: Int) {
        val routineTaskItem: RoutineTaskItem = routineTaskItems[position]
        holder.button.text = routineTaskItem.task
        if (position + 1 == routineTaskItems.size) {
            holder.arrow.visibility = View.GONE
        } else {
            holder.arrow.visibility = View.VISIBLE
        }
    }
}