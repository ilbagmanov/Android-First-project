package com.example.itisdemo.helpClasses

fun search(log: String, pas: String, bases: Array<DataBase>): DataBase {
    for (i in 0..(bases.size - 1)) {
        val x: DataBase = bases.get(i)
        if (x.login.equals(log) && x.password.equals(pas)) {
            return x
        }
    }
    val x : DataBase = DataBase("null","","","","");
    return x
}