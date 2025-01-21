package com.assignment2.studentList.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assignment2.studentList.R
import com.assignment2.studentList.activities.OnItemClickListener
import com.assignment2.studentList.activities.Student
import com.assignment2.studentList.activities.StudentsViewHolder

class StudentsListAdapter(
    private val studentList: MutableList<Student>?
) : RecyclerView.Adapter<StudentsViewHolder>() {

    var listener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentsViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_row_layout, parent, false)
        return StudentsViewHolder(itemView, listener)
    }

    override fun getItemCount(): Int = studentList?.size ?: 0

    override fun onBindViewHolder(holder: StudentsViewHolder, position: Int) {
        studentList?.get(position)?.let { holder.bind(it) }
    }
}