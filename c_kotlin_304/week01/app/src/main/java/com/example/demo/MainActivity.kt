package com.example.demo

import android.graphics.drawable.Icon
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.demo.ui.theme.DemoTheme
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApp()

        }
    }
}
@Composable
fun MyApp() {
    // 创建一个 NavController
    val navController = rememberNavController()

    // 设置 NavHost 和导航图
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") { HomeScreen(navController) }
        composable("second") { SecondScreen(navController) }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    var notes by remember { mutableStateOf(listOf<Note>()) }
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    // 使用 NavController 跳转到第二个页面
                    navController.navigate("second")
                },
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(
                    imageVector = Icons.Default.Add, // 一个箭头图标
                    contentDescription = "Add Note"
                )
            }
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            NoteList(notes)
        }
    }
}

@Composable
fun NoteList(notes: List<Note> ) {
    val noteList:List<Note> = mutableListOf(
        Note(
            id=1,
            title="note 1",
            content = "content"
        ), Note(
            id=2,
            title="note 2",
            content = "content"
        ),
        Note(
            id=3,
            title="note 3",
            content = "content"
        )
    )

    LazyColumn{
        if(notes.isEmpty()){
            notes.plus(noteList);
        }
        items(notes.size){ index ->
            NoteView(note = notes[index])
        }
    }

}
@Composable
fun NoteView(note:Note){
    Column{
        Text(text=note.title)
        Spacer(modifier = Modifier.size(16.dp))
        Text(text=note.content)
    }
}
@Composable
fun SecondScreen(navController: NavController) {
    val context = LocalContext.current

    // 定义输入状态
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Add a New Note",
                style = MaterialTheme.typography.titleLarge
            )

            // 输入标题
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Title") },
                modifier = Modifier.fillMaxWidth()
            )

            // 输入内容
            OutlinedTextField(
                value = content,
                onValueChange = { content = it },
                label = { Text("Content") },
                modifier = Modifier.fillMaxWidth()
            )

            // 保存按钮
            Button(
                onClick = {
                    // 保存 Note（模拟逻辑）
                    if (title.isNotBlank() && content.isNotBlank()) {
                        Toast.makeText(context, "Note Saved!", Toast.LENGTH_SHORT).show()
                        navController.navigateUp() // 返回 HomeScreen
                    } else {
                        Toast.makeText(context, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Save")
            }
        }
    }
}
