package com.motline.mushroom.model.dto

import java.time.LocalDateTime

data class Comment(
    val id: Int,
    val userName: String,
    val thumbnail: String,
    val created: LocalDateTime, // to datetime
    val contents: String,

    val thumbUpCount: Int,
    val commentCount: Int,
    val nestedCommentId: Int
)