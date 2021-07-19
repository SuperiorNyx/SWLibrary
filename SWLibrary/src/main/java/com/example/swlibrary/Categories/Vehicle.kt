package com.example.swlibrary.Categories

class Vehicle {
    private var name : String = ""
    private var model : String = ""
    private var length : String = ""
    private var crew : String = ""

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