package com.wei.tong.ViewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.wei.tong.data.Student


class StudentsViewModel : ViewModel() {
    private val _students = mutableStateListOf<Student>()
    val students: List<Student> get() = _students

    fun addNote(student: Student) {
        _students.add(student)
    }
}