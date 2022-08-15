package com.motline.mushroom.repository

import com.motline.mushroom.common.getRandomId
import com.motline.mushroom.common.getRandomToken
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
            User("name", getRandomToken()),
            LocalDateTime.now(),
            contents = "여기가 어디에여?\n" +
                    "자문자답 : 서울 강서구 공항대로 432 (우)07655 여기군요.\n" +
                    "근데 왜 부천 하이웨이라고 했을까여 ㅎ",
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
        val comment = c.copy(id = getRandomId())
        this.comments.add(comment)
        return comment
    }

}