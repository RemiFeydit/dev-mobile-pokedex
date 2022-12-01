package com.notag.pokedex

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.notag.pokedex.models.Pokemon

class PokemonAdapter(context: Context, private val resource: Int, objects: ArrayList<Pokemon>)
    : ArrayAdapter<Pokemon>(context, resource, objects) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var myConvertView = convertView
        var myViewHolder: ViewHolder

        //if (myConvertView == null) {
        myConvertView = LayoutInflater.from(context).inflate(resource, null)

        myViewHolder = ViewHolder()


        myViewHolder.itemPokemonName = myConvertView!!.findViewById(R.id.itemPokemonName)
        myViewHolder.itemPokemonImage = myConvertView.findViewById(R.id.itemPokemonImage)

        val item = getItem(position)

        /* Picasso.get()
            .load(item?.image)
            .resize(500, 500)
            .into(myViewHolder.itemPokemonImage)

         */

        myViewHolder.itemPokemonName?.setText(item!!.name)


        return myConvertView

    }

    class  ViewHolder {
        var itemPokemonName: TextView? = null
        var itemPokemonImage: ImageView? = null
    }

    }