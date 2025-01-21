package com.assignment2.studentList.activities

import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.assignment2.studentList.R

interface OnItemClickListener {
    fun onItemClick(position: Int)
    fun onStudentClick(student: Student?)
}

class StudentsViewHolder(itemView: View, listener: OnItemClickListener?) : RecyclerView.ViewHolder(itemView) {

    private val studentNameTextView: TextView = itemView.findViewById(R.id.studentNameTextView)
    private val studentIdTextView: TextView = itemView.findViewById(R.id.studentIdTextView)
    private val studentCheckBox: CheckBox = itemView.findViewById(R.id.studentCheckBox)
    private var student: Student? = null

    init {
        studentCheckBox.setOnClickListener {
            val currentStudent = Model.instance.getStudents()[bindingAdapterPosition]
            currentStudent.isChecked = studentCheckBox.isChecked
        }

        itemView.setOnClickListener {
            Log.i("TAG", "StudentsViewHolder: Clicked on position $bindingAdapterPosition")
            listener?.onItemClick(bindingAdapterPosition)
            listener?.onStudentClick(student)
        }
    }

    fun bind(student: Student?) {
        this.student = student
        studentNameTextView.text = student?.name
        studentIdTextView.text = student?.id
        studentCheckBox.isChecked = student?.isChecked ?: false
    }
}