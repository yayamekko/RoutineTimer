package com.yayame.routinetimer.activity

import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.yayame.routinetimer.R

class RoutineTaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var button: Button = itemView.findViewById(R.id.routine_task_id)
}