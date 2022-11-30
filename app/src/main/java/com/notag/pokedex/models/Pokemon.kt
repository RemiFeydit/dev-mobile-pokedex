package com.notag.pokedex.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon(
    val order: Int,
    val name: String,
    val stats : Array<Stat>
) : Parcelable {
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
