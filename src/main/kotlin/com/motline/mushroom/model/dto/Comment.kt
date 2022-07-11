package com.motline.mushroom.model.dto

import java.time.LocalDateTime

data class Comment(
    val id: String?,
    val user: User,
    val created: LocalDateTime, // to datetime
    val contents: String,

    val likeCount: Int = 0,
    val nestedCommentCount: Int = 0
)