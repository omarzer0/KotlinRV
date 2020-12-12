package com.azapps.kotlinrecyclerview

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnExampleItemClickListener {
    private val exampleList = generateDummyList(4)
    private val adapter = ExampleAdapter(exampleList, this)
    private var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setRecyclerView()
    }

    private fun setRecyclerView() {
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
    }

    private fun generateDummyList(size: Int): ArrayList<ExampleItem> {
        val list = ArrayList<ExampleItem>()
        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_person
                1 -> R.drawable.ic_audio
                else -> R.drawable.ic_sun
            }
            val item = ExampleItem(drawable, "Item $i", "Line $i")
            list += item
        }
        return list
    }

    fun insertItem(view: View) {
        val item = ExampleItem(R.drawable.ic_plus_one, "added item $counter", "line #$counter")
        exampleList.add(3, item)
        counter++
        adapter.notifyItemInserted(3)
    }

    fun removeItem(view: View) {
        if (exampleList.size > 3) {
            exampleList.removeAt(3)
            adapter.notifyItemRemoved(3)
            Toast.makeText(this@MainActivity, "list size =${exampleList.size}", Toast.LENGTH_SHORT)
                .show()
        }
    }

    override fun onExampleClick(position: Int) {
        Toast.makeText(this, "Item at position $position", Toast.LENGTH_SHORT).show()
        val clickedItem = exampleList[position]
        clickedItem.imageRes = R.drawable.ic_clicked
        clickedItem.name = "clicked"
        adapter.notifyItemChanged(position)
    }

}