package net.myanmarlinks.kodeinproject.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import net.myanmarlinks.kodeinproject.repository.StudentRepository

class StudentsViewModelFactory(private val studentRepository: StudentRepository) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return StudentViewModel(studentRepository) as T
    }
}