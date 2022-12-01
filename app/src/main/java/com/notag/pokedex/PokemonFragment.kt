package com.notag.pokedex

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

        /* val textViewPokemonNumber = view.findViewById(R.id.textViewPokemonNumber) as TextView
        val textViewPokemonName = view.findViewById(R.id.textViewPokemonName) as TextView
        val textViewPokemonHp = view.findViewById(R.id.textViewPokemonHp) as TextView
        val textViewPokemonAtk = view.findViewById(R.id.textViewPokemonAtk) as TextView
        val textViewPokemonDef = view.findViewById(R.id.textViewPokemonDef) as TextView
        val textViewPokemonSpeAtk = view.findViewById(R.id.textViewPokemonSpeAtk) as TextView
        val textViewPokemonSpeDef = view.findViewById(R.id.textViewPokemonSpeDef) as TextView
        val textViewPokemonSpeed = view.findViewById(R.id.textViewPokemonSpeed) as TextView

        val queue = Volley.newRequestQueue(context)
        val url = "https://pokeapi.co/api/v2/pokemon/1"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {response ->
                Log.i("JSON", response)
                val pokemon = Gson().fromJson(response, Pokemon::class.java)
                val stat = Gson().toJson(pokemon.stats)
                val newStat = Gson().fromJson(stat, Array<Stat>::class.java).toList()
                textViewPokemonNumber.text = "N° : ${pokemon.order.toString()}"
                textViewPokemonName.text = "Name : ${pokemon.name.substring(0, 1).uppercase() + pokemon.name.substring(1).lowercase()}"
                textViewPokemonHp.text = "HP : ${newStat[0].base_stat}"
                textViewPokemonAtk.text = "Atk : ${newStat[1].base_stat}"
                textViewPokemonDef.text = "Def : ${newStat[2].base_stat}"
                textViewPokemonSpeAtk.text = "Spe Atk : ${newStat[3].base_stat}"
                textViewPokemonSpeDef.text = "Spe Def : ${newStat[4].base_stat}"
                textViewPokemonSpeed.text = "Speed : ${newStat[5].base_stat}"




            },
            {

            }
        )
        queue.add(stringRequest)

         */
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