package com.example.barcodeapp.domain.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.barcodeapp.R
import com.example.barcodeapp.domain.models.Superhero
import com.squareup.picasso.Picasso

class SuperheroAdapter(val superheroes: List<Superhero>) : RecyclerView.Adapter<SuperheroAdapter.ViewHolder>() {
    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val name = item.findViewById<TextView>(R.id.tv_product_name)
        val image = item.findViewById<ImageView>(R.id.tv_product_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return superheroes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val superhero = superheroes[position]
        holder.name.text = superhero.name
        Picasso.get().load(superhero.image).into(holder.image)
    }
}