package com.ilia.kotlinlanguagebasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // get reference to button
        val btnFunctions = findViewById<Button>(R.id.btnFunctions)
        // set on-click listener
        btnFunctions.setOnClickListener {
            val sum = sum(5,6)
            Toast.makeText(this@MainActivity, "sum=$sum", Toast.LENGTH_SHORT).show()
            printSum1(7,8)
        }
        //
        val btnLoops = findViewById<Button>(R.id.btnLoops)
        btnLoops.setOnClickListener {
            val numbers: List<Int> = listOf(1, 2, 3, 4, 5, 6)
            for (number in numbers) {
                Toast.makeText(this@MainActivity, "number=$number", Toast.LENGTH_SHORT).show()
            }
        }
        //
        val btnWhen = findViewById<Button>(R.id.btnWhen)
        btnWhen.setOnClickListener{
            val str=describe ("some string")
            Toast.makeText(this@MainActivity, "description=$str", Toast.LENGTH_SHORT).show()

        }

        //
        val sumLambda = { a: Int, b: Int -> a + b }
        val result = sumLambda(9, 3)
        val btnLampda = findViewById<Button>(R.id.btnLampda)
        //
        btnLampda.setOnClickListener{
            val sumLambda = { a: Int, b: Int -> a + b }
            val result = sumLambda(9, 3)
            Toast.makeText(this@MainActivity, "sum from lampda=$result", Toast.LENGTH_SHORT).show()

        }
        //

        //When lampda has a single parameter, "it" is used to represent the single parameter
        // we pass to lambda expression:
        val numbers = arrayOf(1,-2,3,-4,5)
        //The longhand form of lambda function is:
        //println(numbers.filter {item -> item > 0 })
        //
        val btnIt = findViewById<Button>(R.id.btnIt)
        //
        btnIt.setOnClickListener{
            val listOfPositiveNumbers = numbers.filter {  it > 0 }

            for (number in listOfPositiveNumbers) {
                Toast.makeText(
                    this@MainActivity,
                    "number = $number",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        //

        // Using Kotlin classes
        val btnClasses = findViewById<Button>(R.id.btnClasses)
        btnClasses.setOnClickListener{
            // Using primary constructor
            val person = Person("John", "Stone", 27)
            Toast.makeText(
                this@MainActivity,
                "person = ${person.upperCaseFirstName}, ${person.upperCaseLastName}, ${person.age}",
                Toast.LENGTH_SHORT
            ).show()
        }
        // Using Kotlin data classes
        val btnDataClasses = findViewById<Button>(R.id.btnDataClasses)
        btnDataClasses.setOnClickListener{
            // Using primary constructor
            val user = User("john stone", 27)
            println("name = ${user.name}")
            println("age = ${user.age}")
            Toast.makeText(
                this@MainActivity,
                "user = ${user.name}, ${user.age}",
                Toast.LENGTH_SHORT
            ).show()
        }

    } //

    //
    fun describe(obj: Any): String =
        when (obj) {
            1          -> "One"
            "Hello"    -> "Greeting"
            is Long    -> "Long"
            !is String -> "Not a string"
            else       -> "Unknown"
        }
    //


    // Function having two Int parameters with Int return type
    fun sum(a: Int, b: Int): Int {
        return a + b
    }
    // Function returning no meaningful value
    fun printSum1(a: Int, b: Int): Unit {
        Toast.makeText(this@MainActivity, "sum of $a and $b is ${a + b}", Toast.LENGTH_SHORT).show()
    }
    // Unit return type can be omitted
    fun printSum2(a: Int, b: Int) {
        println("sum of $a and $b is ${a + b}")
    }
    //


}