package com.notag.pokedex.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.Objects

@Parcelize
data class Abilities(
    val name: String,
    var flavor_text_entries: List<FlavorTextEntry>
) : Parcelable {
    @Parcelize
    data class FlavorTextEntry(
        val flavor_text: String,
        val language: Language,
    ) : Parcelable {
        @Parcelize
        data class Language(
            val name: String,
        ) : Parcelable

    }

}