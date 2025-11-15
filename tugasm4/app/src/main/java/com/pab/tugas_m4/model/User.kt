package com.pab.tugas_m4.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val name: String,
    val email: String,
    val age: Int
) : Parcelable

