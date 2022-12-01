package com.notag.pokedex.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Moves(
    val name: String,
    val power: Int?,
    var flavor_text_entries: List<FlavorTextEntry>,
    val type: Type,
    val accuracy: Int?,
    val pp: Int,
    val damage_class: DamageClass,
) : Parcelable {
    @Parcelize
    data class FlavorTextEntry(
        val flavor_text: String,
        val language: Language,
        val version_group: VersionGroup,
    ) : Parcelable {
        @Parcelize
        data class Language(
            val name: String,
            val url: String,
        ) : Parcelable

        @Parcelize
        data class VersionGroup(
            val name: String,
            val url: String,
        ) : Parcelable

    }

    @Parcelize
    data class Type(
        val name: String,
        val url: String,
    ) : Parcelable

    @Parcelize
    data class DamageClass(
        val name: String,
        val url: String,
    ) : Parcelable

}
