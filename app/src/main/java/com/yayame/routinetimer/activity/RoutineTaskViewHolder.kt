package com.yayame.routinetimer.activity

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yayame.routinetimer.R

class RoutineTaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var task: TextView = itemView.findViewById(R.id.routine_task_id)
    var arrow: ImageView = itemView.findViewById(R.id.routine_task_arrow)
    var minute: TextView = itemView.findViewById(R.id.routine_task_minute)
}