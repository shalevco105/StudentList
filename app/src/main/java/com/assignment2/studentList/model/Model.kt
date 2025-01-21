package com.example.studentsapp.model

class Model private constructor() {

    private val students: MutableList<Student> = ArrayList()

    companion object {
        val instance = Model()
    }

    fun getStudents(): MutableList<Student> {
        return this.students
    }

    fun getStudentByIndex(index: Int): Student {
        return this.students[index]
    }

    fun addStudent(student: Student) {
        this.students.add(student)
    }

    fun removeStudent(index: Int) {
        this.students.removeAt(index)
    }

    fun saveUpdatedStudent(index: Int, student: Student) {
        this.students[index] = student
    }

    fun getStudentsCount(): Int {
        return this.students.size
    }

}