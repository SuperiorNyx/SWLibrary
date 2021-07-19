package com.example.swlibraryexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.swlibrary.APICall
import com.example.swlibrary.Categories.Planet
import com.example.swlibrary.VCallback

class PlanetActivity : AppCompatActivity(), RVAdapter.ItemClickListener {
    lateinit var rvAdapter : RVAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planet)
        APICall.loadInfo(this, "planets/", object : VCallback {
            override fun onSuccess(result: ArrayList<Any>?) {
                makeRecyclerList(result as? ArrayList<Planet>)
            }
        })
    }

    override fun onItemClick(view: View?, position: Int) {
        Toast.makeText(this, "Yay we did it!", Toast.LENGTH_SHORT).show()
    }

    fun makeRecyclerList(people: ArrayList<Planet>?){
        Log.d("RESULTS MAIN", people!![0].getPlanetName())
        val recyclerView : RecyclerView = findViewById(R.id.recycleView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val names = arrayListOf<String>()
        people.forEach {
            names.add(it.getPlanetName())
        }
        rvAdapter = RVAdapter(this, names)
        rvAdapter.setClickListener(this)
        recyclerView.adapter = rvAdapter
    }
}