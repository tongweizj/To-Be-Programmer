package com.centennial.simplemvvmapp.di

import com.centennial.simplemvvmapp.data.UserRepository
import com.centennial.simplemvvmapp.data.UserRepositoryImpl
import com.centennial.simplemvvmapp.viewmodel.UserViewModel
import org.koin.dsl.module

val appModules = module {
    single<UserRepository> { UserRepositoryImpl() }
    single { UserViewModel(get()) }
}