package com.notag.pokedex.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.Objects

@Parcelize
data class Abilities(
    val name: String,
    val flavor_text_entries: List<FlavorTextEntry>
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

}
