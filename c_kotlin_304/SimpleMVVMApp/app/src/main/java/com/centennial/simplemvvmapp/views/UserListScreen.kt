package com.centennial.simplemvvmapp.views


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel


import com.centennial.simplemvvmapp.data.User
import com.centennial.simplemvvmapp.viewmodel.UserViewModel



@Composable
fun UserListScreen(modifier: Modifier) {
    val userViewModel: UserViewModel = koinViewModel()
    //val users by userViewModel.users.collectAsState()
    val users = userViewModel.getUsers()

    LazyColumn(
        modifier = modifier
    ) {
        items(users) { user ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Name: ${user.name}")
                Text(text = "Species: ${user.age}")
            }
        }
    }

//    LazyColumn(
//        modifier = modifier
//    ){
//        items(users) { user ->
//                UserItem(user)
//            }
//        }
    }
//
//@Composable
//fun UserItem(user: User) {
//    Column(modifier = Modifier.padding(8.dp)) {
//        Text(text = "Name: ${user.name}", style = MaterialTheme.typography.bodyLarge)
//        Text(text = "Age: ${user.age}", style = MaterialTheme.typography.bodyMedium)
//    }
//}