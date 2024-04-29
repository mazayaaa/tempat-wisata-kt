package com.example.utspemob

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TempatWisata(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable