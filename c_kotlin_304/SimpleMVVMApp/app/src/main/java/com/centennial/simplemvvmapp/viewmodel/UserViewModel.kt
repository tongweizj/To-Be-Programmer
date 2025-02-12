package com.centennial.simplemvvmapp.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.centennial.simplemvvmapp.data.User
import com.centennial.simplemvvmapp.data.UserRepository

import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class UserViewModel(
    private val userRepository : UserRepository) : ViewModel() {

        fun getUsers() = userRepository.getUsers()
//    val users: StateFlow<List<User>> = repository.getUsers()
//        .stateIn(
//            scope = viewModelScope,
//            started = SharingStarted.WhileSubscribed(5000),
//            initialValue = emptyList()
//        )
}
