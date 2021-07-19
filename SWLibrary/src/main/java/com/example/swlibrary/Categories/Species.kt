package com.example.swlibrary.Categories

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Species(private var name : String,
              private var designation : String,
              private var skin_colors : String,
              private var hair_colors: String,
              private var eye_colors : String,
              private var language : String) : Parcelable {


    fun getSpeciesName() : String {
        return this.name
    }

    fun getDesignation() : String {
        return this.designation
    }

    fun getSkinColors() : String {
        return this.skin_colors
    }

    fun getHairColors() : String {
        return this.hair_colors
    }

    fun getEyeColors() : String {
        return this.eye_colors
    }

    fun getLanguage() : String {
        return this.language
    }

    override fun toString() : String {
        return "Name: ${this.getSpeciesName()} \n" +
                "Designation: ${this.getDesignation()} \n" +
                "Skin colors: ${this.getSkinColors()} \n" +
                "Hair colors: ${this.getHairColors()} \n" +
                "Eye colors: ${this.getEyeColors()} \n" +
                "Language: ${this.getLanguage()} "
    }
}