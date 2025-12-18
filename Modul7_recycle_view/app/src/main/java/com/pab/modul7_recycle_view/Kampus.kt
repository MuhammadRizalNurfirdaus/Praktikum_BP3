package com.pab.modul7_recycle_view

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Kampus(
    val nama: String,
    val lokasi: String,
    val sejarah: String,
    val photo: Int
) : Parcelable
