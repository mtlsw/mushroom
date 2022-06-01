package com.motline.mushroom.model.dto

import java.time.LocalDateTime

data class Survey(
    val id: String?,
    val author: User,
    val created: LocalDateTime, // to datetime

    val description: String,
    val candidates: List<Candidate>, // max 4? 5?

    val likes: List<String> = emptyList(), // list of user id?
    val dislikes: List<String> = emptyList(), // list of user id?
    val comments: List<Comment> = emptyList()
)