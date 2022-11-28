package com.notag.pokedex.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Moves(
    val name: String,
    val power: Int?,
    val content: String,
    val type: String,
    val accuracy: Int?,
    val pp: Int,
    val attributes: String,
) : Parcelable
