package com.motline.mushroom.service

import com.motline.mushroom.common.getRandomToken
import com.motline.mushroom.model.dto.Comment
import com.motline.mushroom.model.dto.User
import com.motline.mushroom.repository.CommentRepository
import com.motline.mushroom.repository.ReactionRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

/*
val id: String?,
    val user: User,
    val created: LocalDateTime, // to datetime
    val contents: String,
    val surveyId: String,
 */
@Service
class CommentService(
    private val commentRepository: CommentRepository,
    private val reactionRepository: ReactionRepository
    ) {

    suspend fun getAll(surveyId: String): List<Comment> {
        return commentRepository.getAll(surveyId)
    }

    suspend fun get(commentId: String): Comment? {
        return commentRepository.get(commentId)
    }

    // TODO: User 넣어야함.
    suspend fun save(contents: String, surveyId: String): Comment {
        val c = Comment(
            id = null,
            user = User(name = "심솔", getRandomToken()),
            contents = contents,
            surveyId = surveyId,
            created = LocalDateTime.now()
        )

        return commentRepository.save(c)
    }

    suspend fun like(commentId: String, user: User) {

    }
}