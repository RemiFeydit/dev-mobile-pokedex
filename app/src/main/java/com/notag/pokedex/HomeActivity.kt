package com.notag.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    private val bottomNavigationView: BottomNavigationView by lazy { findViewById(R.id.bottomNavigationView) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, PokemonFragment.newInstance("Pikachu", "60"))
            .commit()

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
            .replace(R.id.container, PokemonFragment.newInstance("Pikachu", "60"))
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