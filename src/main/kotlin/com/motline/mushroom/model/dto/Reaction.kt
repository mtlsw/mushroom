package com.motline.mushroom.model.dto

data class Reaction(
    val id: String?,
    val type: Int,
    val targetId: String,
    val user: User,
)
