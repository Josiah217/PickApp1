package edu.temple.pickapp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        val title = findViewById<TextView>(R.id.textView2)
        val picture = findViewById<ImageView>(R.id.imageView)

        val _title = intent.getStringExtra("name")
        val _picture = intent.getIntExtra("image",R.drawable.a)

        picture.setImageResource(_picture)
        title.text = _title
    }
}