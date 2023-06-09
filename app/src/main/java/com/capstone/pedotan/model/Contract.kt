package com.capstone.pedotan.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Contract(
    val id: Int,
    val investor: String,
    val company: String,
    val loan: Int
) : Parcelable

object ContractData {
    val contracts = listOf(
        Contract(
            1,
            "Pak Joko",
            "ABC Corporation",
            10_000_000
        ),
        Contract(
            2,
            "Bu Rina",
            "XYZ Industries",
            12_500_000
        ),
        Contract(
            3,
            "Pak Budi",
            "DEF Company",
            11_200_000
        ),
        Contract(
            4,
            "Pak Sutrisno",
            "GHI Group",
            15_000_000
        ),
        Contract(
            5,
            "Bu Yanti",
            "JKL Enterprises",
            9_800_000
        ),
        Contract(
            6,
            "Pak Slamet",
            "MNO Corporation",
            14_500_000
        ),
        Contract(
            7,
            "Pak Suparno",
            "PQR Industries",
            10_500_000
        ),
        Contract(
            8,
            "Pak Suhardi",
            "STU Company",
            13_200_000
        ),
        Contract(
            9,
            "Pak Bambang",
            "VWX Enterprises",
            12_000_000
        ),
        Contract(
            10,
            "Pak Agus",
            "YZA Group",
            11_800_000
        )
    )
}
