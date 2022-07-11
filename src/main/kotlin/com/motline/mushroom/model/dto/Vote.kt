package com.motline.mushroom.model.dto

data class Vote(
    val id: String = "",
    val label: String,
    val thumbnail: String,
    val vote: Int
)

