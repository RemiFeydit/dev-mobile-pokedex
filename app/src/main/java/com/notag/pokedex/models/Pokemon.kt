package com.notag.pokedex.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon(
    val order: Int,
    val name: String,
    val stats : Array<Stat>,
    val types : List<Types>,
    val sprites: Sprites
) : Parcelable {
    @Parcelize
    data class Types(
        val slot: Int,
        val type: Type
    ) : Parcelable {
        @Parcelize
        data class Type(
            val name: String,
            val url: String
        ) : Parcelable
    }
    @Parcelize
    data class Sprites(
        val other: Other,
        val front_default: String,
    ) : Parcelable {
        @Parcelize
        data class Other(
            val home: Home
        ) : Parcelable {
            @Parcelize
            data class Home(
                val front_default: String,
                val front_shiny: String
            ) : Parcelable
        }
    }
}

