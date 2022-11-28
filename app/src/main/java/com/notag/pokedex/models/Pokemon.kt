package com.notag.pokedex.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon(
    val pokedexId: Int,
    val name: String,
    val hp: Int,
    val atk: Int,
    val def: Int,
    val speAtk: Int,
    val speDef: Int,
    val speed: Int,
    val types: List<String>,
    val moves: List<Moves>,
    val abilities: List<Abilities>,
    val weight: Float,
    val height: Float,
    val sprite: String,
) : Parcelable
