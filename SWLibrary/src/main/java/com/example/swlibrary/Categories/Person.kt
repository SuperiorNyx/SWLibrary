package com.example.swlibrary.Categories

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Person (
    private var name: String,
    private var eye_color: String,
    private var birth_year: String,
    private var url: String
    ) : Parcelable {
    fun getPersonName() : String {
        return this.name
    }

    fun getEyeColor() : String {
        return this.eye_color
    }

    fun getBirthYear() : String {
        return this.birth_year
    }

    fun getUrl() : String {
        return this.url
    }

    override fun toString() : String {
        return "Name: ${this.getPersonName()} \n" +
                "Eye color: ${this.getEyeColor()} \n" +
                "Birth year: ${this.getBirthYear()}"
    }
}

