package com.pab.modul7_recycle_view

// Simple data class without Parcelable to avoid parcelize dependency in this exercise
data class Kampus(
    val nama: String,
    val lokasi: String,
    val sejarah: String,
    val photo: Int
)
