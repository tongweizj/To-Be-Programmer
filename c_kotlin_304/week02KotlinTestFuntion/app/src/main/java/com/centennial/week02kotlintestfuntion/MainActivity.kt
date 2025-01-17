package com.centennial.week02kotlintestfuntion

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.centennial.week02kotlintestfuntion.ui.theme.Week02KotlinTestFuntionTheme
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Week02KotlinTestFuntionTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
                    Mune(
                        padding = innerPadding
                    )
                }
            }
        }
    }
}
@Composable
fun Mune(padding:PaddingValues) {
    val context = LocalContext.current
    Column {
        Button(
            onClick = {
                val add = add(10,20)
                Toast.makeText(context, "10 + 20 = $add", Toast.LENGTH_SHORT).show()
                println("Button clicked - log message")

            }, // 点击事件
            modifier = Modifier.padding(16.dp)
        ) {
            Text("10 + 20")
        }



        Button(
            onClick = {
                val div = div(100.0,10.0)
                Toast.makeText(context, "100 / 10 = $div", Toast.LENGTH_SHORT).show()
                println("100 / 10")

            }, // 点击事件
            modifier = Modifier.padding(16.dp)
        ) {
            Text("100 / 10")
        }

        Button(
            onClick = {
                val names = showList(listOf("Jim","Mike","Tom"))
                Toast.makeText(context, names, Toast.LENGTH_SHORT).show()
                println("Button clicked - log message")

            }, // 点击事件
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Show a name list!")
        }
    }


}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Week02KotlinTestFuntionTheme {
        Greeting("Android")
    }
}

fun add(a:Int, b:Int): Int {
    return a+b
}

fun div(a:Double, b:Double): Double {
    return a/b
}

fun showList(list:List<String>):String{
    var str = ""
    for(item in list){
        str += "$item,  "
    }
    return str
}