package com.notag.pokedex

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.Gson
import com.notag.pokedex.models.Abilities
import com.notag.pokedex.models.Moves
import com.notag.pokedex.models.Pokemon
import kotlinx.coroutines.delay
import java.util.*
import kotlin.concurrent.schedule

interface MyInterface {
    fun onCallback(response: Boolean)
}

class HomeActivity : AppCompatActivity(), MyInterface {
    val myInterface = this
    private val bottomNavigationView: BottomNavigationView by lazy { findViewById(R.id.bottomNavigationView) }
    private var listPokemon = arrayListOf<Pokemon>()
    private var listAbility = arrayListOf<Abilities>()
    private var listMove = arrayListOf<Moves>()

    override fun onCallback(response: Boolean) {

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        val queue = Volley.newRequestQueue(this@HomeActivity)

        for (i in 1..154) {
            val url = String.format("https://pokeapi.co/api/v2/pokemon/%d", i)

            val stringRequest = JsonObjectRequest(
                Request.Method.GET, url, null,
                { response ->
                    myInterface.onCallback(true)
                    // Log.i("JSON", response)
                    var pokemon = Gson().fromJson(response.toString(), Pokemon::class.java)
                    listPokemon.add(pokemon)

                    listPokemon = listPokemon.sortedWith(compareBy<Pokemon> { it.order }).toCollection(ArrayList())
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.container, PokemonFragment.newInstance(listPokemon))
                        .commit()
                },
                {

                }
            )
            queue.add(stringRequest)
        }

        for (i in 1..268) {

            var url = String.format("https://pokeapi.co/api/v2/ability/%d", i)

            val stringRequest = JsonObjectRequest(
                Request.Method.GET, url, null,
                { response ->
                    myInterface.onCallback(true)
                    // Log.i("JSON", response)
                    var abilities = Gson().fromJson(response.toString(), Abilities::class.java)
                    println(abilities)
                    val frContent = abilities?.flavor_text_entries?.filter { flavor -> flavor.language.name == "fr" }

                    abilities?.flavor_text_entries = mutableListOf<Abilities.FlavorTextEntry>(frContent!![0])
                    listAbility.add(abilities)
                },
                {

                }
            )
            queue.add(stringRequest)
        }

        for (i in 1..826) {

            var url = String.format("https://pokeapi.co/api/v2/move/%d", i)

            val stringRequest = JsonObjectRequest(
                Request.Method.GET, url, null,
                { response ->
                    myInterface.onCallback(true)
                    // Log.i("JSON", response)
                    var moves = Gson().fromJson(response.toString(), Moves::class.java)
                    println(moves)
                    val frContent = moves?.flavor_text_entries?.filter { flavor -> flavor.language.name == "fr" }

                    moves?.flavor_text_entries = mutableListOf<Moves.FlavorTextEntry>(frContent!![0])
                    listMove.add(moves)
                },
                {

                }
            )
            queue.add(stringRequest)
        }



        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId)
            {
                R.id.pokemon_page -> {
                    loadFragmentPokemon()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.talent_page -> {
                    loadFragmentTalent()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.attack_page -> {
                    loadFragmentAttack()
                    return@setOnNavigationItemSelectedListener true
                }
                else -> false
            }
        }



    }

    private fun loadFragmentPokemon() {
        listPokemon = listPokemon.sortedWith(compareBy<Pokemon> { it.order }).toCollection(ArrayList())
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, PokemonFragment.newInstance(listPokemon))
            .commit()
    }

    private fun loadFragmentTalent() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, TalentFragment.newInstance(listAbility))
            .commit()
    }

    private fun loadFragmentAttack() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, AttackFragment.newInstance(listMove))
            .commit()
    }




}

