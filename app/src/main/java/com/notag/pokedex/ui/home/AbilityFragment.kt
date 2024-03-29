package com.notag.pokedex.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ListView
import androidx.core.widget.doAfterTextChanged
import com.notag.pokedex.ui.detailAbilities.DetailAbilitiesActivity
import com.notag.pokedex.R
import com.notag.pokedex.models.Abilities

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_ABILITY = "param1"
private const val ARG_CONTENT = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TalentFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AbilityFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var abilities: ArrayList<Abilities>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            abilities = it.getParcelableArrayList(ARG_ABILITY)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ability, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listViewAbilities = view.findViewById(R.id.ListViewAbilities) as ListView
        val editTextRechercheAbilities = view.findViewById(R.id.EditTextRechercheAbilities) as EditText

        listViewAbilities.adapter = AbilityAdapter(
            requireContext(),
            R.layout.item_abilities,
            abilities!!
        )

        listViewAbilities.setOnItemClickListener { parent, view, position, id ->
            var item = abilities!!.get(position)

            println(item)

            val intentAbility = Intent(context, DetailAbilitiesActivity::class.java)

            intentAbility.putExtra("ability", item)

            startActivity(intentAbility)
        }

        // Recherche
        editTextRechercheAbilities.doAfterTextChanged {
            var printListAbility = abilities?.filter {
                    ability -> ability.name.lowercase().contains(editTextRechercheAbilities.text.toString().lowercase())
            }?.toCollection(ArrayList())
            listViewAbilities.adapter = AbilityAdapter(
                requireContext(),
                R.layout.item_abilities,
                printListAbility!!
            )
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TalentFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(abilities: ArrayList<Abilities>) =
            AbilityFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList(ARG_ABILITY, abilities)
                }
            }
    }
}