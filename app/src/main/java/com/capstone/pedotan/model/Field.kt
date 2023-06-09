package com.capstone.pedotan.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Field(
    val id: Int,
    val komoditas: String,
    val lokasi: String,
    val luasKebun: Int,
    val status: String
) : Parcelable

object FieldData {
    val fields = listOf(
        Field(
            1,
            "Ganja",
            "Karanganyar",
            100,
            "Kurang"
        ),
        Field(
            2,
            "Kopi",
            "Finished",
            100,
            "Baik"
        ),
    )
}