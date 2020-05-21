package com.example.itisdemo


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.net.toUri
import kotlinx.android.synthetic.main.activity_second.*
import com.example.itisdemo.helpClasses.*
import kotlinx.android.synthetic.main.activity_second.name

class SecondActivity : AppCompatActivity() {

    val APP_PREFERENCES = "signUp"

    override fun onCreate(savedInstanceState: Bundle?) {
        val x: DataBase? = getIntent().getExtras()?.getParcelable<DataBase>("DATA")
        val pref: SharedPreferences = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        val editor = pref.edit()
        editor.putString(APP_PREFERENCES, x!!.login + ":" + x.password);
        editor.apply()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        email.text = "EMAIL: " + x.login
        name.text = "NAME: " + x.name
        surname.text = "SURNAME: " + x.surname
        imageView2.setImageURI("android.resource://com.example.itisdemo/drawable/${x.imgPath}".toUri())
    }

    fun signOut(view: View) {
        val pref: SharedPreferences = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        val editor = pref.edit()
        editor.remove(APP_PREFERENCES)
        editor.apply()
        super.finish();
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
