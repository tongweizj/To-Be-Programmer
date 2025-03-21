package com.wei.simplemvvmroomapp.data

import kotlinx.coroutines.flow.Flow
// 这段代码是 Android MVVM (Model-View-ViewModel) 架构 中的 Repository 层，
// 用于 封装数据库操作，提供数据给 ViewModel。
// 它通过 UserDao 访问 Room 数据库，并使用 Flow 进行数据流管理。
class UserRepository(private val userDao: UserDao) {
    val allUsers: Flow<List<User>> = userDao.getAllUsers()

    suspend fun insertUser(user: User) {
        userDao.insertUser(user)
    }
}
