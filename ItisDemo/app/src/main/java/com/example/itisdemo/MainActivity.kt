package com.example.itisdemo

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.itisdemo.helpClasses.DataBase
import com.example.itisdemo.helpClasses.search
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var bases: Array<DataBase> = passwordBase();
    val APP_PREFERENCES = "signUp"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkerSignUp()
    }

    fun checkerSignUp() {
        val pref: SharedPreferences = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        val logPas: String? = pref.getString(APP_PREFERENCES, "Null").toString()
        if (!logPas.equals("Null")) {
            val index: Int = logPas!!.indexOf(':')
            val s1: String = logPas.substring(0, index)
            val s2: String = logPas.substring(index + 1)
            email.setText(s1)
            password.setText(s2)
            val x: DataBase = search(s1, s2, bases);
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("DATA", x);
            startActivity(intent)
        }
    }

    fun enter(view: View) {
        val emailText = email.text.toString();
        val passwordText = password.text.toString();
        if (passwordChecker(passwordText) && emailChecker(emailText)) {
            val x: DataBase = search(emailText, passwordText, bases);
            if (!x.login.equals("null")) {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("DATA", x);
                startActivity(intent)
            } else {
                toastNotFoundAccount();
            }
        } else {
            toastFailInput();
        }
    }

    fun toastNotFoundAccount() {
        val text = "Аккаунт не найден"
        val duration = Toast.LENGTH_SHORT
        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
    }

    fun toastFailInput() {
        val text = "Ошибка в синтаксисе email или пароль"
        val duration = Toast.LENGTH_SHORT
        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
    }

    fun passwordChecker(password: String): Boolean {
        return (password.length >= 6 &&
                password.contains("[a-z]|[а-я]".toRegex()) &&
                password.contains("[A-Z]|[А-Я]".toRegex()) &&
                password.contains("\\d".toRegex())
                )
    }

    fun emailChecker(email: String): Boolean {
        return (email.contains("\\w{1,}@\\w{1,}[.]{1}[A-Za-z]{2,}$".toRegex()))
    }

    fun passwordBase(): Array<DataBase> {
        val data1: DataBase = DataBase("admin@gmail.com", "Admin1", "Dowane", "Johnson ", "admin");
        val data2: DataBase = DataBase("KFU@gmail.com", "KFUtheBest1", "KFU", "University", "kfu");
        val data3: DataBase = DataBase("steve@gmail.com", "AppleTop1", "Steve", "Jobs", "steve");
        val data4: DataBase = DataBase("ildar@gmail.com", "Zz3456", "Ildar", "Bagmanov", "ildar");
        val data5: DataBase = DataBase("stitch@gmail.com", "Djambo1", "Stich", "Experiment 626", "stitch");
        val bases: Array<DataBase> = arrayOf(data1, data2, data3, data4, data5);
        return bases
    }
}