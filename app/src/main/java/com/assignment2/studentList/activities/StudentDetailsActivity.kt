package com.assignment2.studentList.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.assignment2.studentList.R


class StudentDetailsActivity : AppCompatActivity() {

    private var student: Student? = null
    private var studentIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        studentIndex = intent.getIntExtra("student_index", 0)

        student = Model.instance.getStudentByIndex(studentIndex)

        val textViewName = findViewById<TextView>(R.id.textViewStudentName)
        val textViewId = findViewById<TextView>(R.id.textViewStudentId)
        val textViewPhone = findViewById<TextView>(R.id.textViewStudentPhone)
        val textViewAddress = findViewById<TextView>(R.id.textViewStudentAddress)
        val checkBoxChecked = findViewById<CheckBox>(R.id.checkBoxStudentChecked)
        val imageViewDetail = findViewById<ImageView>(R.id.studentDetailImage)

        textViewName.text = student?.name
        textViewId.text = student?.id
        textViewPhone.text = student?.phone
        textViewAddress.text = student?.address
        checkBoxChecked.isChecked = student?.isChecked ?: false
        imageViewDetail.setImageResource(R.drawable.student_background)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun openEditStudentActivity(view: View) {
        val intent = Intent(this, EditStudentActivity::class.java).apply {
            putExtra("student_index", studentIndex)
        }
        startActivity(intent)
        finish()
    }
}