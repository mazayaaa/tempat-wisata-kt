package com.example.utspemob

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val ivTempatWisata: ImageView = findViewById(R.id.iv_tempat_wisata)
        val tvName: TextView = findViewById(R.id.tv_name)
        val tvDescription: TextView = findViewById(R.id.tv_description)

        // Get the TempatWisata data from the intent
        val tempatWisata = intent.getParcelableExtra<TempatWisata>("EXTRA_TEMPAT_WISATA")

        // Display the TempatWisata data
        ivTempatWisata.setImageResource(tempatWisata?.photo ?: 0)
        tvName.text = tempatWisata?.name
        tvDescription.text = tempatWisata?.description
    }
}