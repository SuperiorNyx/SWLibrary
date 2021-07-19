package com.example.swlibraryexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.swlibrary.APICall
import com.example.swlibrary.Categories.Person
import com.example.swlibrary.VCallback

class PeopleActivity : AppCompatActivity(), RVAdapter.ItemClickListener {
    private lateinit var rvAdapter : RVAdapter
    private var resultsList = arrayListOf<Person>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_people)
        APICall.loadInfo(this, "people/", object : VCallback {
            override fun onSuccess(result: ArrayList<Any>?) {
                resultsList = result as ArrayList<Person>
                makeRecyclerList(resultsList)
            }
        })
    }

    override fun onItemClick(view: View?, position: Int) {
        val intent = Intent(this, InfoDialog::class.java)
        intent.putExtra("Data", resultsList[position])
        startActivity(intent)
    }

    fun makeRecyclerList(people: ArrayList<Person>?){
        Log.d("RESULTS MAIN", people!![0].getPersonName())
        val recyclerView : RecyclerView = findViewById(R.id.recycleView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val names = arrayListOf<String>()
        people.forEach {
            names.add(it.getPersonName())
        }
        rvAdapter = RVAdapter(this, names)
        rvAdapter.setClickListener(this)
        recyclerView.adapter = rvAdapter
    }
}