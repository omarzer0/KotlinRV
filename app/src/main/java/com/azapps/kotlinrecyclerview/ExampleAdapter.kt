package com.azapps.kotlinrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter

class ExampleAdapter(private val listener: OnExampleItemClickListener) :
    ListAdapter<ExampleItem, ExampleViewHolder>(DiffUtilExampleCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return ExampleViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.imageView.setImageResource(currentItem.imageRes)
        holder.nameTextView.text = currentItem.name
        holder.textTextView.text = currentItem.text
    }

}