package com.assignment2.studentList.activities

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.assignment2.studentList.R


class EditStudentActivity : AppCompatActivity() {
    private var currentStudent: Student? = null
    private var currentStudentIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_student)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        currentStudentIndex = intent.getIntExtra("student_index", 0)
        currentStudent = Model.instance.getStudentByIndex(currentStudentIndex)

        populateStudentDetails(currentStudent)
    }

    private fun populateStudentDetails(student: Student?) {
        findViewById<EditText>(R.id.editStudentName).setText(student?.name)
        findViewById<EditText>(R.id.editStudentId).setText(student?.id)
        findViewById<EditText>(R.id.editStudentPhone).setText(student?.phone)
        findViewById<EditText>(R.id.editStudentAddress).setText(student?.address)
        findViewById<CheckBox>(R.id.checkboxStudentActive).isChecked = student?.isChecked ?: false
    }

    fun saveUpdatedStudent(view: View) {
        val name = findViewById<EditText>(R.id.editStudentName).text.toString()
        val id = findViewById<EditText>(R.id.editStudentId).text.toString()
        val phone = findViewById<EditText>(R.id.editStudentPhone).text.toString()
        val address = findViewById<EditText>(R.id.editStudentAddress).text.toString()
        val isActive = findViewById<CheckBox>(R.id.checkboxStudentActive).isChecked

        val updatedStudent = Student(name, id, phone, address, isActive)
        Model.instance.saveUpdatedStudent(currentStudentIndex, updatedStudent)

        finishActivity(view)
    }

    fun removeStudentRecord(view: View) {
        Model.instance.removeStudent(currentStudentIndex)

        finishActivity(view)
    }

    fun finishActivity(view: View) {
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}