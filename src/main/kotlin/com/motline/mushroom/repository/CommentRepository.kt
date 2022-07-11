package com.motline.mushroom.repository

import com.motline.mushroom.model.dto.Comment
import org.springframework.stereotype.Component

/*
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
 */
@Component
class CommentRepository {

    private final val comments: MutableList<Comment> = mutableListOf()

    init {

        Comment(


        )
    }



}