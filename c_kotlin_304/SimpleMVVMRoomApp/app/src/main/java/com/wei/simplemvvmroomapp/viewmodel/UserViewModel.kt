package com.wei.simplemvvmroomapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wei.simplemvvmroomapp.data.User
import com.wei.simplemvvmroomapp.data.UserRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository) : ViewModel() {
    val users: StateFlow<List<User>> = repository.allUsers
        .stateIn(
            scope = viewModelScope,

            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun insertUser(user: User) = viewModelScope.launch {
        repository.insertUser(user)
    }
}
