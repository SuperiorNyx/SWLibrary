package com.example.swlibrary.Categories

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Starship(private var name : String,
               private var model : String,
               private var length : String,
               private var crew : String,
               private var hyperdrive_rating : String,
               private var starship_class : String) : Parcelable {


    fun getShipName() : String {
        return this.name
    }

    fun getModel() : String {
        return this.model
    }

    fun getLength() : String {
        return this.length
    }

    fun getCrew() : String {
        return this.crew
    }

    fun getHyperdrive() : String {
        return this.hyperdrive_rating
    }

    fun getClass() : String {
        return this.starship_class
    }

    override fun toString() : String {
        return "Name: ${this.getShipName()} \n" +
                "Model: ${this.getModel()} \n" +
                "Class: ${this.getClass()}"
    }
}