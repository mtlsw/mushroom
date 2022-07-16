package com.motline.mushroom.repository

import com.motline.mushroom.model.dto.NestedComment
import com.motline.mushroom.model.dto.User
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import kotlin.random.Random

@Component
class NestedCommentRepository {

    private final val nestedComments: MutableList<NestedComment> = mutableListOf()

    init {
        val x = NestedComment(
            id = "cdid0",
            commentId = "cid0",
            User("name"),
            LocalDateTime.now(),
            contents = "hello",
            likeCount = 0
        )

        nestedComments.add(x)
    }

    suspend fun get(commentId: String): NestedComment? {
        return nestedComments.find { it.id == commentId }
    }

    suspend fun getAll(commentId: String): List<NestedComment> {
        return nestedComments.filter { it.commentId == commentId }
    }

    suspend fun save(nc: NestedComment): NestedComment {
        val nc = nc.copy(id = Random.nextLong(100000000).toString())
        this.nestedComments.add(nc)
        return nc
    }

}