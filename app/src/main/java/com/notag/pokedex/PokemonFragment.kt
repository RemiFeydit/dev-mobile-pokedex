package com.notag.pokedex

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_name = "name"
private const val ARG_pv = "pv"

/**
 * A simple [Fragment] subclass.
 * Use the [PokemonFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PokemonFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var name: String? = null
    private var pv: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(ARG_name)
            pv = it.getString(ARG_pv)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pokemon, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textViewPokemonName = view.findViewById(R.id.textViewPokemonName) as TextView
        val textViewPokemonPV = view.findViewById(R.id.textViewPokemonPV) as TextView

        textViewPokemonName.text = name
        textViewPokemonPV.text = pv
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
        @JvmStatic fun newInstance(name: String, pv: String) =
                PokemonFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_name, name)
                        putString(ARG_pv, pv)
                    }
                }
    }
}