package com.motline.mushroom.repository

import com.motline.mushroom.model.dto.Comment
import com.motline.mushroom.model.dto.User
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import kotlin.random.Random

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
        val x = Comment(
            "cid0",
            User("name"),
            LocalDateTime.now(),
            "hello",
            surveyId = "sid0"
        )

        comments.add(x)
    }

    suspend fun get(commentId: String): Comment? {
        return comments.find { it.id == commentId }
    }

    suspend fun getAll(surveyId: String): List<Comment> {
        return comments.filter { it.surveyId == surveyId }
    }

    suspend fun save(c: Comment): Comment {
        val comment = c.copy(id = Random.nextLong(100000000).toString())
        this.comments.add(comment)
        return comment
    }

}