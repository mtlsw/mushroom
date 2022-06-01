package com.motline.mushroom.model.dto

data class Candidate(
    val body: String,
    val voted: List<String> = emptyList(), // list of user id?
)

