package edu.temple.pickapp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val colors = arrayOf(
            ImageObject("Bulbasaur", R.drawable.a),
            ImageObject("Charmander", R.drawable.b),
            ImageObject("Squirtle", R.drawable.c),
            ImageObject("Chikorita", R.drawable.d),
            ImageObject("Cyndaquil", R.drawable.e),
            ImageObject("Totodile", R.drawable.f),
            ImageObject("Treecko", R.drawable.g),
            ImageObject("Torchic", R.drawable.h),
            ImageObject("Mudkip", R.drawable.i),
            ImageObject("Mew", R.drawable.j)
        )

        val myRecyclerViewFunc = {colorObject:ImageObject ->
            //mageView.setImageResource(colorObject.resourceId)
            //textView.text = colorObject.name
            //val intent = Intent(this,R.layout.activity_main2:: class.java)
            //intent.putExtra("image",colorObject.resourceId)
            //intent.putExtra("name",colorObject.name)
            //startActivity(intent)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        // Assign a Grid layout manager with 3 columns
        recyclerView.layoutManager = GridLayoutManager(this, 3)

        recyclerView.adapter = ImageAdapter(colors,myRecyclerViewFunc)
    }
}