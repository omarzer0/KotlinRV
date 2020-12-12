package com.azapps.kotlinrecyclerview

import androidx.recyclerview.widget.DiffUtil

class DiffUtilExampleCallback : DiffUtil.ItemCallback<ExampleItem>() {
    override fun areItemsTheSame(oldItem: ExampleItem, newItem: ExampleItem): Boolean {
        return oldItem.text == newItem.text
    }

    override fun areContentsTheSame(oldItem: ExampleItem, newItem: ExampleItem): Boolean {
        return oldItem.name == newItem.name
    }
}