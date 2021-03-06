package com.example.swlibrary
import android.content.Context
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.swlibrary.Categories.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

object APICall {
    val gson: Gson = Gson()
    fun loadInfo(c: Context?, category: String, vCallback: VCallback) {
        val queue = Volley.newRequestQueue(c)
        val url = "https://swapi.dev/api/$category"
        val cat = category.replace("/", "")
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->
                val type : Type
                var responseList : ArrayList<Any>? = arrayListOf()
                Log.d("TEST", cat)
                when (cat) {
                    "people" -> {
                        type = object : TypeToken<List<Person>>() {}.type
                        responseList = gson.fromJson<ArrayList<Person>>(
                            response.getJSONArray("results").toString(), type
                        ) as? ArrayList<Any>
                        Log.d("RESULTS", "got to people!")
                    }
                    "planets" -> {
                        type = object : TypeToken<List<Planet>>(){}.type
                        responseList = gson.fromJson<ArrayList<Planet>>(
                            response.getJSONArray("results").toString(), type) as? ArrayList<Any>
                    }
                    "films" -> {
                        type = object : TypeToken<List<Film>>(){}.type
                        responseList = gson.fromJson<ArrayList<Film>>(
                            response.getJSONArray("results").toString(), type) as? ArrayList<Any>
                    }
                    "species" -> {
                        type = object : TypeToken<List<Species>>(){}.type
                        responseList = gson.fromJson<ArrayList<Species>>(
                            response.getJSONArray("results").toString(), type) as? ArrayList<Any>
                    }
                    "starships" -> {
                        type = object : TypeToken<List<Starship>>(){}.type
                        responseList = gson.fromJson<ArrayList<Starship>>(
                            response.getJSONArray("results").toString(), type) as? ArrayList<Any>
                    }
                    "vehicles" -> {
                        type = object : TypeToken<List<Vehicle>>(){}.type
                        responseList = gson.fromJson<ArrayList<Vehicle>>(
                            response.getJSONArray("results").toString(), type) as? ArrayList<Any>
                    }
                    else -> { Toast.makeText(c,"Unknown Category!", Toast.LENGTH_LONG).show() }
                }
                vCallback.onSuccess(responseList)
            },
            {
                Log.d("error", it.localizedMessage)
                Toast.makeText(c,"That didn't work!", Toast.LENGTH_LONG).show()
            })
        queue.add(jsonObjectRequest)
    }
}