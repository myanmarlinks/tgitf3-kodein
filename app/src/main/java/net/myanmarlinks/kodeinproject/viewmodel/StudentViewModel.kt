package net.myanmarlinks.kodeinproject.viewmodel

import androidx.lifecycle.ViewModel
import net.myanmarlinks.kodeinproject.model.Student
import net.myanmarlinks.kodeinproject.repository.StudentRepository

class StudentViewModel(private val studentRepository: StudentRepository): ViewModel() {
    fun addStudent(student: Student) = studentRepository.addStudent(student)
    fun getStudents() = studentRepository.getStudents()
}