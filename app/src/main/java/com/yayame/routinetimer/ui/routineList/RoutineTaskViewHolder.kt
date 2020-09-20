package com.yayame.routinetimer.ui.routineList

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.yayame.routinetimer.R

class RoutineTaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val taskName: TextView = itemView.findViewById(R.id.routine_task_name)
    val arrow: ImageView = itemView.findViewById(R.id.routine_task_arrow)
    val minute: TextView = itemView.findViewById(R.id.routine_task_minute)
    val task: ConstraintLayout = itemView.findViewById(R.id.routine_task)
}