package com.wei.simplemvvmroomapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.*

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wei.simplemvvmroomapp.data.User
import com.wei.simplemvvmroomapp.data.UserDatabase
import com.wei.simplemvvmroomapp.data.UserRepository
import com.wei.simplemvvmroomapp.ui.theme.SimpleMVVMRoomAppTheme
import com.wei.simplemvvmroomapp.viewmodel.UserViewModel
import com.wei.simplemvvmroomapp.viewmodel.UserViewModelFactory

class MainActivity : ComponentActivity() {
    //  Android ViewModel 的初始化
    private val userViewModel: UserViewModel by viewModels {
        UserViewModelFactory(UserRepository(UserDatabase.getDatabase(application).userDao()))
    }
    // 这快代码是固定写法
    // by viewModels 是 Kotlin 委托 (Delegate)，
    // 它会自动创建 UserViewModel 的实例，
    // 并在 Activity 或 Fragment 作用域内管理它。
    // 作用：保证 UserViewModel 在 Activity 或 Fragment 生命周期内保持数据，不会因为界面旋转等操作被销毁。

    // UserViewModelFactory：这是一个自定义的 ViewModel 工厂类，用于创建 UserViewModel 实例，并传入它所需的参数。
    //UserRepository(UserDatabase.getDatabase(application).userDao())：
    //UserDatabase.getDatabase(application): 获取 单例 的 Room 数据库实例。
    //.userDao(): 从数据库中获取 DAO (Data Access Object)，用于数据库操作。
    //UserRepository(...): 创建 仓库类 (Repository)，用于管理数据来源 (数据库、网络等)。
    //作用：通过工厂类 (UserViewModelFactory) 让 UserViewModel 具有 UserRepository 作为依赖，以便它能访问数据。
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleMVVMRoomAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UserListScreen(userViewModel)
                }
            }
        }
    }
}

@Composable
fun UserListScreen(userViewModel: UserViewModel) {
    // 在组件中，申明state
    val users by userViewModel.users.collectAsState()
    // 🔹 collectAsState() 在 Jetpack Compose 中用于将 StateFlow 转换为可观察的 UI 状态。
    //🔹 by 关键字 使 users 直接等于 State 的 value，简化代码。
    //🔹 UI 会自动更新，当 users 数据变化时，无需手动 observe。
    val (name, setName) = remember { mutableStateOf("") }
    val (age, setAge) = remember { mutableStateOf("") }
// ✅ mutableStateOf("") 创建 可变状态，初始值为 ""。
//✅ remember {} 确保状态在 UI 重新渲染时不会丢失。
//✅ val (name, setName) = ... 使用 解构声明，简化状态读取和更新。
//✅ UI 会自动更新，当 setName 修改 name 后，Compose 触发 重新组合 (Recomposition)。
//
//这是 Jetpack Compose 响应式 UI 的核心之一，让 UI 与状态同步更新！
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "User List", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = name,
            onValueChange = setName, //使用state 中的setName功能
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = age,
            onValueChange = setAge,
            label = { Text("Age") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            val user = User(name = name, age = age.toInt())
            userViewModel.insertUser(user)
            setName("")
            setAge("")
        }) {
            Text("Add User")
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(users) { user ->
                UserItem(user)
            }
        }
    }
}

@Composable
fun UserItem(user: User) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(text = "Name: ${user.name}", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Age: ${user.age}", style = MaterialTheme.typography.bodyMedium)
    }
}

