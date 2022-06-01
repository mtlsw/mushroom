package com.motline.mushroom.model.request

import com.motline.mushroom.model.dto.Candidate
import com.motline.mushroom.model.dto.Comment
import com.motline.mushroom.model.dto.User
import com.motline.mushroom.model.dto.Survey
import java.time.LocalDateTime

data class VoteSaveRequest(
    val author: User,
    val created: LocalDateTime, // to datetime

    val description: String,
    val candidates: List<Candidate>, // max 4? 5?

    val likes: List<String> = emptyList(), // list of user id?
    val dislikes: List<String> = emptyList(), // list of user id?
    val comments: List<Comment> = emptyList()
) {

    fun toVote(): Survey {
        return Survey(
            author = author,
            candidates = candidates,
            created = created,
            description = description,
            likes = likes,
            dislikes = dislikes,
            comments = comments,
            id = null
        )
    }
}