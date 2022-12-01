package com.notag.pokedex

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.notag.pokedex.models.Abilities

class DetailAbilitiesActivity : AppCompatActivity() {

    private val textViewAbilityName: TextView by lazy { findViewById<TextView>(R.id.textViewAbilityName) }
    private val textViewAbilityContent: TextView by lazy { findViewById<TextView>(R.id.textViewAbilityContent) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_abilities)

        val ability = intent.getParcelableExtra<Abilities>("ability")

        println(ability)

        textViewAbilityName.text = ability?.name
        textViewAbilityContent.text = ability?.flavor_text_entries?.get(0)?.flavor_text
    }
}