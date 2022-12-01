package com.notag.pokedex

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.notag.pokedex.models.Pokemon

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_POKEMONS = "name"

/**
 * A simple [Fragment] subclass.
 * Use the [PokemonFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PokemonFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var pokemons: ArrayList<Pokemon>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            pokemons = it.getParcelableArrayList(ARG_POKEMONS)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pokemon, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val listViewPokemons = view.findViewById(R.id.ListViewPokemons) as ListView

        listViewPokemons.adapter = PokemonAdapter(
            requireContext(),
            R.layout.item_pokemon,
            pokemons!!
        )

        listViewPokemons.setOnItemClickListener { parent, view, position, id ->
            val item = pokemons!!.get(position)


            val intentPokemon = Intent(context, DetailPokemonActivity::class.java)

            intentPokemon.putExtra("pokemon", item)

            startActivity(intentPokemon)


        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param name Parameter 1.
         * @param pv Parameter 2.
         * @return A new instance of fragment PokemonFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic fun newInstance(pokemons: ArrayList<Pokemon>) =
                PokemonFragment().apply {
                    arguments = Bundle().apply {
                        putParcelableArrayList(ARG_POKEMONS, pokemons)
                    }
                }
    }
}