package com.motline.mushroom.model.request

import com.motline.mushroom.model.dto.User

/*
val id: String?,
    val user: User,
    val created: LocalDateTime, // to datetime
    val contents: String,
    val surveyId: String,
 */
data class NestedCommentSaveRequest(
    val contents: String
)
