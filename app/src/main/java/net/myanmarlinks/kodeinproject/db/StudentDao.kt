package net.myanmarlinks.kodeinproject.db

import androidx.lifecycle.LiveData
import net.myanmarlinks.kodeinproject.model.Student

interface StudentDao {
    fun addStudent(student: Student)
    fun getStudents(): LiveData<List<Student>>
}