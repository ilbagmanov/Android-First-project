package com.example.itisdemo

/*
Тут я изучал KOTLIN поэтому не обращайте внимания.
*/
fun main(args : Array<String>) {
    val i = 2;
    val name = "Kik Butovski";
    println(Integer.toString(i) + " " + name);
    for(n in 1..10 step 2){
        print(Integer.toString(n) + "; ")
    }
    val numbers: Array<Int> = arrayOf(1, 2, 3, 4, 5)
    println();
    println(4 in numbers)
    println(2 !in numbers)
    displayUser("Ildar", 18)
}

fun displayUser(name: String, age: Int, company: String = "KFU"){
    println("Name: $name   Age: $age")
}