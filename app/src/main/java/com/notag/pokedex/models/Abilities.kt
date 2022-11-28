package com.notag.pokedex.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Abilities(
    val name: String,
    val content: String,
) : Parcelable
