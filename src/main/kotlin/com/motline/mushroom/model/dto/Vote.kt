package com.motline.mushroom.model.dto

data class Vote(
    val id: Int = 0,
    val label: String,
    val thumbnail: String,
    val voted: Int
)

