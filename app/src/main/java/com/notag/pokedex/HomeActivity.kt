package com.notag.pokedex

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.Gson
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

    override fun onCallback(response: Boolean) {

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        val queue = Volley.newRequestQueue(this@HomeActivity)

        for (i in 1..151) {
            val url = String.format("https://pokeapi.co/api/v2/pokemon/%d", i)

            val stringRequest = JsonObjectRequest(
                Request.Method.GET, url, null,
                { response ->
                    myInterface.onCallback(true)
                    // Log.i("JSON", response)
                    var pokemon = Gson().fromJson(response.toString(), Pokemon::class.java)
                    listPokemon.add(pokemon)
                },
                {

                }
            )
            queue.add(stringRequest)
        }

        Timer(false).schedule(4000) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, PokemonFragment.newInstance(listPokemon))
                .commit()
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
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, PokemonFragment.newInstance(listPokemon))
            .commit()
    }

    private fun loadFragmentTalent() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, TalentFragment.newInstance("Coloforce", "Double l'attaque physique"))
            .commit()
    }

    private fun loadFragmentAttack() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, AttackFragment.newInstance("Tonnerre", "90"))
            .commit()
    }




}

