package com.example.swlibrary
import android.content.Context
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

object APICall {
    val gson: Gson = Gson()
    fun loadInfo(c: Context?, category: String, vCallback: VCallback) {
        val queue = Volley.newRequestQueue(c)
        val url = "https://swapi.dev/api/$category"
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->
                val type : Type
                var responseList : ArrayList<Any>? = arrayListOf()
                when (category) {
                    "people/" -> {
                        type = object : TypeToken<List<Person>>() {}.type
                        responseList = gson.fromJson<ArrayList<Person>>(
                            response.getJSONArray("results").toString(), type
                        ) as? ArrayList<Any>
                        Log.d("RESULTS", "got to people!")
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