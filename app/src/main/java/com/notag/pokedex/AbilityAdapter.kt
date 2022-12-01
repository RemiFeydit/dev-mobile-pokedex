package com.notag.pokedex

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.notag.pokedex.models.Abilities
import com.notag.pokedex.models.Pokemon

class AbilityAdapter(context: Context, private val resource: Int, objects: ArrayList<Abilities>)
    : ArrayAdapter<Abilities>(context, resource, objects) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var myConvertView = convertView
        var myViewHolder: ViewHolder

        //if (myConvertView == null) {
        myConvertView = LayoutInflater.from(context).inflate(resource, null)

        myViewHolder = ViewHolder()


        myViewHolder.itemAbilityName = myConvertView!!.findViewById(R.id.itemAbilityName)

        val item = getItem(position)

        /* Picasso.get()
            .load(item?.image)
            .resize(500, 500)
            .into(myViewHolder.itemPokemonImage)

         */
        myViewHolder.itemAbilityName?.setText(item!!.name)


        return myConvertView

    }

    class  ViewHolder {
        var itemAbilityName: TextView? = null
    }

}