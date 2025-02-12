package com.centennial.simplemvvmapp.data


import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

interface UserRepository {
    fun getUsers(): List<User>
}
