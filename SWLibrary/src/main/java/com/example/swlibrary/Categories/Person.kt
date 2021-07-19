package com.example.swlibrary.Categories

class Person {
    private var name: String = ""
    private var eyeColor: String = ""
    private var birthYear: String = ""
    private var url: String = ""

    fun getPersonName() : String {
        return this.name
    }

    fun getEyeColor() : String {
        return this.eyeColor
    }

    fun getBirthYear() : String {
        return this.birthYear
    }

    fun getUrl() : String {
        return this.url
    }
}