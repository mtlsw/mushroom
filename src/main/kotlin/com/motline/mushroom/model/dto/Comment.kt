package com.motline.mushroom.model.dto

data class Comment(
    val author: User,
    val created: Long, // to datetime
    val body: String,
    val likes: List<String> = emptyList(), // list of user id?
    val subComments: List<Comment> = emptyList(),
)