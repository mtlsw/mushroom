package com.motline.mushroom.model.dto

data class Vote(
    val author: User,
    val created: Long, // to datetime
//    val title: String,
    val voteCount: Int, // sum of candidates?
    val description: String,
    val candidates: List<Candidate>, // max 4? 5?

    val likes: List<String>, // list of user id?
    val comments: List<Comment>
)

data class Article(
    val author: User,
    val created: Long, // to datetime
    val description: String,
    val candidates: List<Candidate>?, // max 4? 5?

    val likes: List<String>, // list of user id?
    val dislikes: List<String>, // list of user id?

    val comments: List<Comment>
)

data class Comment(
    val author: User,
    val created: Long, // to datetime
    val body: String,
    val likes: List<String>, // list of user id?
    val subComments: List<Comment> = emptyList(),

)
data class Candidate(
    val body: String,
    val voted: List<String>, // list of user id?

)

data class User(
    val name: String
)