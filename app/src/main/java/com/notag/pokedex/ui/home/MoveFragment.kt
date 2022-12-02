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
import com.notag.pokedex.ui.detailMoves.DetailMovesActivity
import com.notag.pokedex.R
import com.notag.pokedex.models.Moves

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_NAME = "param1"

/**
 * A simple [Fragment] subclass.
 * Use the [AttackFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MoveFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var moves: ArrayList<Moves>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            moves = it.getParcelableArrayList(ARG_NAME)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_move, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listViewMoves = view.findViewById(R.id.ListViewMoves) as ListView
        val editTextRechercheMoves = view.findViewById(R.id.EditTextRechercheMoves) as EditText

        listViewMoves.adapter = MoveAdapter(
            requireContext(),
            R.layout.item_moves,
            moves!!
        )

        listViewMoves.setOnItemClickListener { parent, view, position, id ->
            var item = moves!!.get(position)

            println(item)

            val intentMove = Intent(context, DetailMovesActivity::class.java)

            intentMove.putExtra("move", item)

            startActivity(intentMove)
        }

        // Recherche
        editTextRechercheMoves.doAfterTextChanged {
            var printListMove = moves?.filter {
                    ability -> ability.name.lowercase().contains(editTextRechercheMoves.text.toString().lowercase())
            }?.toCollection(ArrayList())
            listViewMoves.adapter = MoveAdapter(
                requireContext(),
                R.layout.item_moves,
                printListMove!!
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
         * @return A new instance of fragment AttackFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(moves: ArrayList<Moves>) =
            MoveFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList(ARG_NAME, moves)
                }
            }
    }
}