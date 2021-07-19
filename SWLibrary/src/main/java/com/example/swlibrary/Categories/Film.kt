package com.example.swlibrary.Categories

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Film(private var title : String,
                private var opening_crawl : String,
                private var release_date : String
                ) : Parcelable {

    fun getFilmTitle() : String {
        return this.title
    }

    fun getOpening() : String {
        return this.opening_crawl
    }

    fun getReleaseDate() : String {
        return this.release_date
    }

    override fun toString() : String {
        return "Title: ${this.getFilmTitle()} \n" +
                "Release date: ${this.getReleaseDate()} \n" +
                this.getOpening()
    }
}