package com.motline.mushroom.model.dto

import java.time.LocalDateTime

data class Survey(
    val id: Int = 0,
    val user: User,
    val created: LocalDateTime, // to datetime

    val contents: String,
    val votes: List<Vote>, // max 4? 5?

    val likeCount: Int,
    val commentCount: Int,

    val currentUserReaction: Boolean

//    val likes: List<String> = emptyList(), // list of user id?
//    val dislikes: List<String> = emptyList(), // list of user id?
//    val comments: List<Comment> = emptyList(),

)