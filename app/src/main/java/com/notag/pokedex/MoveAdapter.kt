package com.notag.pokedex

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.notag.pokedex.models.Abilities
import com.notag.pokedex.models.Moves

class MoveAdapter(context: Context, private val resource: Int, objects: ArrayList<Moves>)
    : ArrayAdapter<Moves>(context, resource, objects) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var myConvertView = convertView
        var myViewHolder: ViewHolder

        //if (myConvertView == null) {
        myConvertView = LayoutInflater.from(context).inflate(resource, null)

        myViewHolder = ViewHolder()


        myViewHolder.itemMoveName = myConvertView!!.findViewById(R.id.itemMoveName)

        val item = getItem(position)

        /* Picasso.get()
            .load(item?.image)
            .resize(500, 500)
            .into(myViewHolder.itemPokemonImage)

         */
        val moveName = item!!.name
        myViewHolder.itemMoveName?.text =
            moveName.substring(0, 1)?.uppercase() + moveName.substring(1)?.lowercase()


        return myConvertView

    }

    class  ViewHolder {
        var itemMoveName: TextView? = null
    }

}