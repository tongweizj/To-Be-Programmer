package com.wei.tong.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

import com.wei.tong.ViewModel.StudentsViewModel
import com.wei.tong.data.Student
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TongActivityContent(navController: NavController,studentsViewModel: StudentsViewModel = viewModel()) {
    var name by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("mail@mycentennial.com") }
    var studentType by remember { mutableStateOf("") }
    val students = studentsViewModel.students
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    @Composable
    fun RadioButtonSingleSelection(onSave: (String) -> Unit,modifier: Modifier = Modifier) {
        val radioOptions = listOf("Regular", "Part-Time", "International")
//        val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }
        val (selectedOption, onOptionSelected) = remember { mutableStateOf("") }
        // Note that Modifier.selectableGroup() is essential to ensure correct accessibility behavior
        Column(modifier.selectableGroup()) {
            radioOptions.forEach { text ->
                Row(
                    Modifier
                        .fillMaxWidth()
                        .height(36.dp)
                        .selectable(
                            selected = (text == selectedOption),
                            onClick = {

                                onOptionSelected(text)
                                onSave(text)},
                            role = Role.RadioButton
                        )
                        .padding(horizontal = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (text == selectedOption),
                        onClick = null // null recommended for accessibility with screen readers
                    )
                    Text(
                        text = text,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Add Student") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
    ) { innerPadding ->
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            label = { Text("Phone Number") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))
        Text("Select Student Type")
//        Row {
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(innerPadding)
//                    .padding(16.dp)
//            ) {
//                RadioButton(
//                    selected = (studentType == "Regular"),
//                    onClick = { studentType = "Regular" })
//                Text("Regular")
//                Spacer(modifier = Modifier.width(8.dp))
//                RadioButton(
//                    selected = (studentType == "Part-Time"),
//                    onClick = { studentType = "Part-Time" })
//                Text("Part-Time")
//                Spacer(modifier = Modifier.width(8.dp))
//                RadioButton(
//                    selected = (studentType == "International"),
//                    onClick = { studentType = "International" })
//                Text("International")
//            }
//        }
        RadioButtonSingleSelection(onSave = { type ->
            studentType = type
        })
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if (name.isNotEmpty() && phoneNumber.isNotEmpty()&& email.isNotEmpty()&& studentType.isNotEmpty()) {
                studentsViewModel.addNote(Student(name, phoneNumber, email,studentType))
                scope.launch {
                    snackbarHostState.showSnackbar("Student saved successfully")
                }
            }else{
                scope.launch {
                    snackbarHostState.showSnackbar("Can not save student information due to missing data")
                }
            }
        }) {
            Text("Add Student")
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(students.size) { index ->
                Text("${students[index].name}, ${students[index].phoneNumber}, ${students[index].email}, ${students[index].studentType}")
            }
        }
    }
}


}