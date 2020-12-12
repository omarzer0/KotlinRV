package com.azapps.kotlinrecyclerview

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*

class ExampleViewHolder(itemView: View, clickListener: OnExampleItemClickListener) :
    RecyclerView.ViewHolder(itemView), View.OnClickListener {

    val imageView: ImageView = itemView.item_layout_img_image_view
    val nameTextView: TextView = itemView.item_layout_tv_item_name_text_view
    val textTextView: TextView = itemView.item_layout_tv_item_line_text_view
    val listener: OnExampleItemClickListener

    init {
        itemView.setOnClickListener(this)
        listener = clickListener
    }

    override fun onClick(p0: View?) {
        listener.onExampleClick(adapterPosition)
    }
}