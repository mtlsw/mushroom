package com.motline.mushroom.model.dto

import java.time.LocalDateTime

data class NestedComment(
    val id: String? = "0",
    val commentId: String = "0",
    val user: User,
    val created: LocalDateTime,
    val contents: String,
    val likeCount: Int = 0,
    val me: Boolean = false
)
