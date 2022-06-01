package com.motline.mushroom.model.request

import com.motline.mushroom.model.dto.Vote
import com.motline.mushroom.model.dto.Comment
import com.motline.mushroom.model.dto.User
import com.motline.mushroom.model.dto.Survey
import java.time.LocalDateTime

data class SurveySaveRequest(
    val user: User,
    val created: LocalDateTime, // to datetime

    val contents: String,
    val votes: List<Vote>, // max 4? 5?

    val likeCount: Int,
    val commentCount: Int,
    val currentUserReaction: Boolean
) {

    fun toSurvey(): Survey {
        return Survey(
            user = user,
            votes = votes,
            created = created,
            contents = contents,
            id = 0,
            currentUserReaction = false,
            commentCount = 0,
            likeCount = 0
        )
    }
}