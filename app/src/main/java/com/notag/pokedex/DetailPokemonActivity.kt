package com.notag.pokedex

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.notag.pokedex.models.Pokemon
import com.notag.pokedex.models.Stat
import com.squareup.picasso.Picasso

class DetailPokemonActivity : AppCompatActivity() {

    private val imageViewPokemonImage: ImageView by lazy { findViewById<ImageView>(R.id.imageViewPokemonImage) }
    private val textViewPokemonName: TextView by lazy { findViewById<TextView>(R.id.textViewPokemonName) }
    private val textViewPokemonHp: TextView by lazy { findViewById<TextView>(R.id.textViewPokemonHp) }
    private val textViewPokemonAtk: TextView by lazy { findViewById<TextView>(R.id.textViewPokemonAtk) }
    private val textViewPokemonDef: TextView by lazy { findViewById<TextView>(R.id.textViewPokemonDef) }
    private val textViewPokemonSpeAtk: TextView by lazy { findViewById<TextView>(R.id.textViewPokemonSpeAtk) }
    private val textViewPokemonSpeDef: TextView by lazy { findViewById<TextView>(R.id.textViewPokemonSpeDef) }
    private val textViewPokemonSpeed: TextView by lazy { findViewById<TextView>(R.id.textViewPokemonSpeed) }
    private val buttonSite: Button by lazy { findViewById<Button>(R.id.buttonSite) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_pokemon)

        val pokemon = intent.getParcelableExtra<Pokemon>("pokemon")
        var isShiny: Boolean = false

        println(pokemon)

        val stat = Gson().toJson(pokemon?.stats)
        val newStat = Gson().fromJson(stat, Array<Stat>::class.java).toList()
        textViewPokemonName.text =
            pokemon?.name?.substring(0, 1)?.uppercase() + pokemon?.name?.substring(1)?.lowercase()
        textViewPokemonHp.text = "HP : ${newStat[0].base_stat}"
        textViewPokemonAtk.text = "Atk : ${newStat[1].base_stat}"
        textViewPokemonDef.text = "Def : ${newStat[2].base_stat}"
        textViewPokemonSpeAtk.text = "Spe Atk : ${newStat[3].base_stat}"
        textViewPokemonSpeDef.text = "Spe Def : ${newStat[4].base_stat}"
        textViewPokemonSpeed.text = "Speed : ${newStat[5].base_stat}"
        imageViewPokemonImage.setOnClickListener {
            if (!isShiny) {
                isShiny = true
                Picasso
                    .get()
                    .load(pokemon?.sprites?.other?.home?.front_shiny)
                    .into(imageViewPokemonImage);
            } else {
                isShiny = false
                Picasso
                    .get()
                    .load(pokemon?.sprites?.other?.home?.front_default)
                    .into(imageViewPokemonImage);
            }

        }

        Picasso
            .get()
            .load(pokemon?.sprites?.other?.home?.front_default)
            .into(imageViewPokemonImage);

        buttonSite.setOnClickListener {
            val intentSite = Intent(Intent.ACTION_VIEW, Uri.parse(String.format("https://www.pokemon.com/us/pokedex/%s", pokemon?.name?.lowercase())))
            startActivity(Intent.createChooser(intentSite, "Navigateur web"))
        }
    }
}