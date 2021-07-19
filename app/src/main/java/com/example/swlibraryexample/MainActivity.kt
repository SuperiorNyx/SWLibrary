package com.example.swlibraryexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun loadPeople(view: View) {
        val intent = Intent(this, PeopleActivity::class.java)
        startActivity(intent)
    }
}