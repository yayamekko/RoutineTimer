package com.yayame.routinetimer.activity

import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.yayame.routinetimer.R

class RoutineTaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var button: Button = itemView.findViewById(R.id.routine_task_id)
    var arrow: ImageView = itemView.findViewById(R.id.routine_task_arrow)
}