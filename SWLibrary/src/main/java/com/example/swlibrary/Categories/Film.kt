package com.example.swlibrary.Categories

class Film {
    private var title: String = ""
    private var opening_crawl: String = ""
    private var release_date: String = ""

    fun getFilmTitle() : String {
        return this.title
    }

    fun getOpening() : String {
        return this.opening_crawl
    }

    fun getReleaseDate() : String {
        return this.release_date
    }
}