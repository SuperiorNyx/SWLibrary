package com.example.swlibrary.Categories

class Starship {
    private var name : String = ""
    private var model : String = ""
    private var length : String = ""
    private var crew : String = ""
    private var hyperdrive_rating : String = ""
    private var starship_class : String = ""

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
}