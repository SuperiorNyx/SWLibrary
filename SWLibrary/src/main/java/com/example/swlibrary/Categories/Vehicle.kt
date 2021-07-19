package com.example.swlibrary.Categories

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Vehicle(
    private var name : String,
    private var model : String,
    private var length : String,
    private var crew : String) : Parcelable {

    fun getVehicleName() : String {
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
}