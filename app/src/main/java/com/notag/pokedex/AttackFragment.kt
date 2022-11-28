package com.notag.pokedex

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_NAME = "param1"
private const val ARG_POWER = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AttackFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AttackFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var name: String? = null
    private var power: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(ARG_NAME)
            power = it.getString(ARG_POWER)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_attack, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textViewAttackName = view.findViewById(R.id.textViewAttackName) as TextView
        val textViewAttackPower = view.findViewById(R.id.textViewAttackPower) as TextView

        textViewAttackName.text = name
        textViewAttackPower.text = power
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AttackFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(name: String, power: String) =
            AttackFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_NAME, name)
                    putString(ARG_POWER, power)
                }
            }
    }
}