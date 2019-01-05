package net.myanmarlinks.kodeinproject.repository

import net.myanmarlinks.kodeinproject.db.StudentDao
import net.myanmarlinks.kodeinproject.model.Student

class StudentRepositoryImpl(private val studentDao: StudentDao): StudentRepository {
    override fun addStudent(student: Student) {
        studentDao.addStudent(student)
    }

    override fun getStudents() = studentDao.getStudents()
}