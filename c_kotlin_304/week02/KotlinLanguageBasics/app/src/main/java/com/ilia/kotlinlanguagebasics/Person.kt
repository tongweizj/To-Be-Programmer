package com.ilia.kotlinlanguagebasics

class Person(firstName: String, lastName: String, personAge: Int) {
    val upperCaseFirstName = firstName.toUpperCase()
    val  upperCaseLastName = lastName.toUpperCase()
    //
    var age = personAge
    //
    // initializer block
    init {
        // display in LogCat window
        println("Uppercase First Name = $upperCaseFirstName")
        println("Age = $age")
    }
}