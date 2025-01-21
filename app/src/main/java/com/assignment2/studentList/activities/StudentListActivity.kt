package com.assignment2.studentList.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.assignment2.studentList.R
import com.assignment2.studentList.utils.StudentsListAdapter


class StudentListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students_list_view)

        val studentsListView = findViewById<RecyclerView>(R.id.studentsListView)
        studentsListView.setHasFixedSize(true)
        studentsListView.layoutManager = LinearLayoutManager(this)

        val adapter = StudentsListAdapter(Model.instance.getStudents()).apply {
            listener = object : OnItemClickListener {
                override fun onItemClick(position: Int) {
                    Intent(this@StudentListActivity, StudentDetailsActivity::class.java).also {
                        it.putExtra("student_index", position)
                        startActivity(it)
                    }
                }

                override fun onStudentClick(student: Student?) {
                    Intent(this@StudentListActivity, StudentDetailsActivity::class.java).apply {
                        putExtra("student_name", student?.name)
                        putExtra("student_id", student?.id)
                        putExtra("student_phone", student?.phone)
                        putExtra("student_address", student?.address)
                        putExtra("student_checked", student?.isChecked)
                        startActivity(this)
                    }
                }
            }
        }

        studentsListView.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        (findViewById<RecyclerView>(R.id.studentsListView).adapter as StudentsListAdapter).notifyDataSetChanged()
    }

    fun openCreateStudentActivity(view: View) {
        startActivity(Intent(this, CreateStudentActivity::class.java))
    }
}