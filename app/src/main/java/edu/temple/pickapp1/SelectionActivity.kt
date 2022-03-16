package edu.temple.pickapp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SelectionActivity : AppCompatActivity() {

    val secondActivityLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        Log.d("Returned data", it.data?.getStringExtra("resultValue").toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val array= resources.getStringArray(R.array.ListOfPokemon)
        val titleView = findViewById<TextView>(R.id.textView);

        titleView.text =  getString(R.string.MainTV)

        val colors = arrayOf(
            ImageObject(array[0], R.drawable.a),
            ImageObject(array[1], R.drawable.b),
            ImageObject(array[2], R.drawable.c),
            ImageObject(array[3], R.drawable.d),
            ImageObject(array[4], R.drawable.e),
            ImageObject(array[5], R.drawable.f),
            ImageObject(array[6], R.drawable.g),
            ImageObject(array[7], R.drawable.h),
            ImageObject(array[8], R.drawable.i),
            ImageObject(array[9], R.drawable.j)
        )

        val myRecyclerViewFunc = {colorObject:ImageObject ->
            //mageView.setImageResource(colorObject.resourceId)
            //textView.text = colorObject.name
            val intent = Intent(this,DisplayActivity:: class.java)
            intent.putExtra("image",colorObject.resourceId)
            intent.putExtra("name",colorObject.name)
            secondActivityLauncher.launch(intent)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        // Assign a Grid layout manager with 3 columns
        recyclerView.layoutManager = GridLayoutManager(this, 3)

        recyclerView.adapter = ImageAdapter(colors,myRecyclerViewFunc)
    }
}