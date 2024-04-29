package com.example.utspemob

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val ivProfilePicture: ImageView = findViewById<ImageView>(R.id.iv_profile_picture)
        val tvName: TextView = findViewById(R.id.tv_my_name)
        val tvEmail: TextView = findViewById(R.id.tv_my_email)
        val tvDescription: TextView = findViewById(R.id.tv_profile_desc)

        tvName.text = "Fatharani Mazaya Agniya Putri"
        tvEmail.text = "Email : fatharanimazayaap@gmail.com"
        tvDescription.text = "Saya adalah mahasiswi aktif Sistem Informasi angkatan 2022 di Universitas Pembangunan Nasional Veteran Jawa Timur."
    }
}