package com.motline.mushroom.service

import com.motline.mushroom.model.dto.Comment
import com.motline.mushroom.model.dto.User
import com.motline.mushroom.repository.CommentRepository
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
class CommentService(val commentRepository: CommentRepository) {

    suspend fun getAll(surveyId: String): List<Comment> {
        return commentRepository.getAll(surveyId)
    }

    // TODO: User 넣어야함.
    suspend fun save(contents: String, surveyId: String): Comment {
        val c = Comment(
            id = null,
            user = User(name = "심솔"),
            contents = contents,
            surveyId = surveyId,
            created = LocalDateTime.now()
        )

        return commentRepository.save(c)
    }
}