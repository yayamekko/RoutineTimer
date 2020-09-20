package com.yayame.routinetimer.ui.EditRoutineList

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yayame.routinetimer.R

class RoutineTaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val task: TextView = itemView.findViewById(R.id.routine_task_name)
    val arrow: ImageView = itemView.findViewById(R.id.routine_task_arrow)
    val minute: TextView = itemView.findViewById(R.id.routine_task_minute)
}