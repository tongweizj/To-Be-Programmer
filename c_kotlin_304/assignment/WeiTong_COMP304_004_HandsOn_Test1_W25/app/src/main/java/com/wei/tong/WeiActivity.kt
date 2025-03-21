package com.wei.tong

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.wei.tong.ui.theme.CentennialStudentsTheme
import com.wei.tong.views.TongActivityContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

            setContent {
            MyNotesApp()
            }
        }
    }


@Composable
fun MyNotesApp() {
    val navController = rememberNavController()
    Scaffold() { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "WeiActivity",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("WeiActivity") { WeiActivityContent(navController) }
            composable("TongActivity") { TongActivityContent(navController) }
        }
    }
}


@Composable
fun WeiActivityContent(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo), // Replace with your logo image resource
            contentDescription = "App Logo",
            modifier = Modifier.size(128.dp)
        )
        Spacer(modifier = Modifier.height(60.dp))

        Image(
            painter = painterResource(id = R.drawable.add),
            contentDescription = "Centennial Students",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .clickable {
                    navController.navigate("TongActivity")

                }
        )
//        Button(onClick = { navController.navigate("TongActivity") }) {
//            Text("Centennial Students")
//        }
    }
}