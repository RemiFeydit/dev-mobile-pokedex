package com.notag.pokedex.ui.detailMoves

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.notag.pokedex.R
import com.notag.pokedex.models.Moves

class DetailMovesActivity : AppCompatActivity() {

    private val textViewMoveName: TextView by lazy { findViewById<TextView>(R.id.textViewMoveName) }
    private val textViewMoveContent: TextView by lazy { findViewById<TextView>(R.id.textViewMoveContent) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_moves)

        val move = intent.getParcelableExtra<Moves>("move")

        textViewMoveName.text = move?.name?.substring(0, 1)?.uppercase() + move?.name?.substring(1)?.lowercase()?.replace("-", " ");
        textViewMoveContent.text = move?.flavor_text_entries?.get(0)?.flavor_text
    }
}