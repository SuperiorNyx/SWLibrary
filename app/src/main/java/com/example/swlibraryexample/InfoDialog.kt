package com.example.swlibraryexample

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import com.example.swlibrary.Categories.Person

class InfoDialog : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_dialog)
        val data = intent.getParcelableExtra<Person>("Data")
        var textView : TextView = findViewById(R.id.textView)
        textView.text = data!!.toString()
        Toast.makeText(this, data!!.getEyeColor(), Toast.LENGTH_SHORT).show()
    }
}