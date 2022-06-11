package com.ab.learningsharedpreference

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn: Button = findViewById(R.id.SaveButton)
        btn.setOnClickListener { save() }

        val getShared = getSharedPreferences("demo", MODE_PRIVATE)
        val value1 = getShared.getString("str1", "This is default value")
        val txt = findViewById<TextView?>(R.id.NoteSave).setText(value1).toString()    }

    private fun save() {
        val msg: String = findViewById<View?>(R.id.EditNote).toString()

        val shrd: SharedPreferences = this.getSharedPreferences("demo", MODE_PRIVATE)
        val edt: SharedPreferences.Editor = shrd.edit()

        edt.putString("str1", msg)

        val txt: TextView = findViewById(R.id.NoteSave)
        txt.text = msg

        edt.apply()
    }
}