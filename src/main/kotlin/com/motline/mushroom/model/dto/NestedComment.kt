package com.motline.mushroom.model.dto

import java.time.LocalDateTime

data class NestedComment(
    val id: Int = 0,
    val userName: String,
    val created: LocalDateTime,
    val contents: String,
    val thumbUpCount: Int,
)
