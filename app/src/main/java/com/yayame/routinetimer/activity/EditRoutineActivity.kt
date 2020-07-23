package com.yayame.routinetimer.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yayame.routinetimer.R
import model.RoutineTaskItem

class EditRoutineActivity : AppCompatActivity() {
    private lateinit var routineTaskRecyclerView: RecyclerView
    private lateinit var routineTaskAdapter: RecyclerView.Adapter<RoutineTaskViewHolder>
    private lateinit var routineTaskManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_routine)

        val routineTaskItems = mutableListOf<RoutineTaskItem>()
        setRoutineTaskItems(routineTaskItems)

        routineTaskAdapter = RoutineTaskAdapter(this, routineTaskItems)
        routineTaskManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        routineTaskRecyclerView = findViewById(R.id.routine_task)
        routineTaskRecyclerView.layoutManager = routineTaskManager
        routineTaskRecyclerView.adapter = routineTaskAdapter
    }

    fun setRoutineTaskItems(routineTaskItems: MutableList<RoutineTaskItem>) {
        for (i in 0..3) {
            val routineTaskItem = RoutineTaskItem(i, "task$i", 10)
            routineTaskItems.add(routineTaskItem)
        }
    }


}
