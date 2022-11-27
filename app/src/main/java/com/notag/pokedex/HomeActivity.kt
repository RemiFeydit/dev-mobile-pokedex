package com.notag.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeActivity : AppCompatActivity() {

    private val buttonPokemons: Button by lazy { findViewById(R.id.buttonPokemons) }
    private val buttonTalents: Button by lazy { findViewById(R.id.buttonTalents) }
    private val buttonAttaques: Button by lazy { findViewById(R.id.buttonAttaques) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, PokemonFragment.newInstance("Pikachu", "60"))
            .commit()

        buttonPokemons.setOnClickListener {
            // charger le fragment Onglet1Fragment

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, PokemonFragment.newInstance("Pikachu", "60"))
                .commit()
        }
    }
}