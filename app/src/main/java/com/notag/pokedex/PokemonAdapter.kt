package com.notag.pokedex

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.notag.pokedex.models.Pokemon
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

class PokemonAdapter(context: Context, private val resource: Int, objects: ArrayList<Pokemon>)
    : ArrayAdapter<Pokemon>(context, resource, objects) {

    class  ViewHolder{
        var itemPokemonName: TextView? = null
        var itemPokemonImage: ImageView? = null
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var myConvertView = convertView
        var myViewHolder: ViewHolder

        //if (myConvertView == null) {
        myConvertView = LayoutInflater.from(context).inflate(resource, null)
        myViewHolder = ViewHolder()
        myViewHolder.itemPokemonName = myConvertView!!.findViewById(R.id.itemPokemonName)
        myViewHolder.itemPokemonImage = myConvertView.findViewById(R.id.itemPokemonImage)

        val item = getItem(position)
        Picasso.get()
            .load(item?.sprites?.front_default)
            .resize(500, 500)
            .into(myViewHolder.itemPokemonImage)
        myViewHolder.itemPokemonName?.text = item!!.name.substring(0, 1).uppercase() + item!!.name.substring(1).lowercase();
        return myConvertView

    }
}