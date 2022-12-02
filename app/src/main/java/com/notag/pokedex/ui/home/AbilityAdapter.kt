package com.notag.pokedex.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.notag.pokedex.R
import com.notag.pokedex.models.Abilities

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

        val abilityName = item!!.name
        myViewHolder.itemAbilityName?.text =
            abilityName.substring(0, 1)?.uppercase() + abilityName.substring(1)?.lowercase()?.replace("-", " ")


        return myConvertView

    }

    class  ViewHolder {
        var itemAbilityName: TextView? = null
    }

}