package net.myanmarlinks.kodeinproject.repository

import androidx.lifecycle.LiveData
import net.myanmarlinks.kodeinproject.model.Student

interface StudentRepository {
    fun addStudent(student: Student)
    fun getStudents(): LiveData<List<Student>>
}