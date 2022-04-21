package com.example.parcelablenavigationcomponent

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Biodata(
    val nama: String?,
    val usia: Int?,
    val alamat: String?,
    val pekerjaan: String?
): Parcelable