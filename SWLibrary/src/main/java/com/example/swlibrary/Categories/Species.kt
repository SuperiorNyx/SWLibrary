package com.example.swlibrary.Categories

class Species {
    private var name : String = ""
    private var designation : String = ""
    private var skin_colors : String = ""
    private var hair_colors: String = ""
    private var eye_colors : String = ""
    private var language : String = ""

    fun getSpeciesName() : String {
        return this.name
    }

    fun getDesignation() : String {
        return this.designation
    }

    fun getSkinColors() : String {
        return this.skin_colors
    }

    fun getEyeColors() : String {

        return this.eye_colors
    }

    fun getLanguage() : String {
        return this.language
    }
}