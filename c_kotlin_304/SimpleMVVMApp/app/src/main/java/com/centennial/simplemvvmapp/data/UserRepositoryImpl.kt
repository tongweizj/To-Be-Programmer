package com.centennial.simplemvvmapp.data

class UserRepositoryImpl:UserRepository {

    override fun getUsers():List<User>{
        return listOf(
            User(1, "John Doe", 30),
            User(2, "Jane Doe", 28),
            User(3, "Sam Smith", 25)
        )
    }
}