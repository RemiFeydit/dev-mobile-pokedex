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
        val other: Other
    ) : Parcelable {
        @Parcelize
        data class Other(
            val home: Home
        ) : Parcelable {
            @Parcelize
            data class Home(
                val front_default: String
            ) : Parcelable
        }
    }

    /* @Parcelize
    data class Other(
        val home: Home
    ) : Parcelable {
        @Parcelize
        data class Home(
            val front_default: String
        ) : Parcelable
    }

     */


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Pokemon

        if (order != other.order) return false
        if (name != other.name) return false
        if (!stats.contentEquals(other.stats)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = order
        result = 31 * result + name.hashCode()
        result = 31 * result + stats.contentHashCode()
        return result
    }


}
