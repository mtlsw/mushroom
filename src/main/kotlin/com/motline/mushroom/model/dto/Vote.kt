package com.motline.mushroom.model.dto

import java.time.LocalDateTime

data class Vote(
    val author: User,
    val created: LocalDateTime, // to datetime

    val description: String,
    val candidates: List<Candidate>, // max 4? 5?

    val likes: List<String> = emptyList(), // list of user id?
    val dislikes: List<String> = emptyList(), // list of user id?
    val comments: List<Comment> = emptyList()
)

data class Article(
    val author: User,
    val created: LocalDateTime, // to datetime
    val description: String,
    val candidates: List<Candidate>?, // max 4? 5?

    val likes: List<String> = emptyList(), // list of user id?
    val dislikes: List<String> = emptyList(), // list of user id?

    val comments: List<Comment> = emptyList()
)

data class Comment(
    val author: User,
    val created: Long, // to datetime
    val body: String,
    val likes: List<String> = emptyList(), // list of user id?
    val subComments: List<Comment> = emptyList(),

)
data class Candidate(
    val body: String,
    val voted: List<String> = emptyList(), // list of user id?

)

data class User(
    val name: String
)