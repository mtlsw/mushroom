package com.motline.mushroom.service

import com.motline.mushroom.model.dto.Comment
import com.motline.mushroom.model.dto.NestedComment
import com.motline.mushroom.model.dto.User
import com.motline.mushroom.repository.CommentRepository
import com.motline.mushroom.repository.NestedCommentRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime


@Service
class NestedCommentService(
    val nestedCommentRepository: NestedCommentRepository,
    val commentService: CommentService
    ) {

    /*
    data class NestedComment(
    val id: String? = "0",
    val commentId: String = "0",
    val user: User,
    val created: LocalDateTime,
    val contents: String,
    val likeCount: Int,
)
     */
    suspend fun save(surveyId: String, commentId: String, contents: String): NestedComment {

        // header의 토큰을 이용해서 user를 가져올듯

        val comment = commentService.get(commentId)

        if (comment == null) {
            throw Exception("comment not exist: $commentId")
        } else {
            val user = User("솔님")
            val n = NestedComment(
                commentId = commentId,
                user = user,
                created = LocalDateTime.now(),
                contents = contents,
            )
            return nestedCommentRepository.save(n)
        }
    }

    suspend fun getAll(commentId: String): List<NestedComment> {
        return nestedCommentRepository.getAll(commentId)
    }
}