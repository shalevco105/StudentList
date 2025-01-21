package com.example.studentsapp.activities

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.studentsapp.R
import com.example.studentsapp.model.Model
import com.example.studentsapp.model.Student

class CreateStudentActivity : AppCompatActivity() {
    private lateinit var inputName: EditText
    private lateinit var inputId: EditText
    private lateinit var inputPhone: EditText
    private lateinit var inputAddress: EditText
    private lateinit var checkBoxEnrolled: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_student)

        inputName = findViewById(R.id.inputName)
        inputId = findViewById(R.id.inputId)
        inputPhone = findViewById(R.id.inputPhone)
        inputAddress = findViewById(R.id.inputAddress)
        checkBoxEnrolled = findViewById(R.id.checkBoxEnrolled)
    }

    fun closeActivity(view: View) {
        finish()
    }

    fun saveStudent(view: View) {
        val studentName = inputName.text.toString()
        val studentId = inputId.text.toString()
        val studentPhone = inputPhone.text.toString()
        val studentAddress = inputAddress.text.toString()
        val isEnrolled = checkBoxEnrolled.isChecked

        val student = Student(studentName, studentId, studentPhone, studentAddress, isEnrolled)

        Model.instance.addStudent(student)

        closeActivity(view)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}