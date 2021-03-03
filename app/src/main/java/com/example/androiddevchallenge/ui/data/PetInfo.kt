package com.example.androiddevchallenge.ui.data

import androidx.annotation.DrawableRes

data class PetInfo(
    val id: String,
    val name: String,
    @DrawableRes val avatar: Int,
    val breed: String,
    val weight: String,
    val height: String,
    val gender : String,
    val des: String
) {
}