package com.example.swlibrary.Categories

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Planet(
    private var name: String,
    private var population: String,
    private var climate: String,
    private var url: String
    ) : Parcelable{


    fun getPlanetName() : String {
        return this.name
    }

    fun getPopulation() : String {
        return this.population
    }

    fun getClimate() : String {
        return this.getClimate()
    }

    fun getUrl() : String {
        return this.url
    }

    override fun toString() : String {
        return "Name: ${this.getPlanetName()} \n" +
                "Population: ${this.getPopulation()} \n" +
                "Climate: ${this.getClimate()}"

    }
}