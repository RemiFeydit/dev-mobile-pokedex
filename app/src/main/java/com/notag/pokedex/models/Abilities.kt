package com.notag.pokedex.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Abilities(
    val name: String,
    val content: String,
    val stats: Array<Stat>
) : Parcelable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Abilities

        if (name != other.name) return false
        if (content != other.content) return false
        if (!stats.contentEquals(other.stats)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + content.hashCode()
        result = 31 * result + stats.contentHashCode()
        return result
    }
}
