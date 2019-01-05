package net.myanmarlinks.kodeinproject.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import net.myanmarlinks.kodeinproject.model.Student

class StudentDaoImpl: StudentDao {
    private val studentList = mutableListOf<Student>()
    private val students = MutableLiveData<List<Student>>()
    init {
        students.value = studentList
    }
    override fun addStudent(student: Student) {
        studentList.add(student)
        students.value = studentList
    }

    override fun getStudents() = students as LiveData<List<Student>>
}