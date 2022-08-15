package com.motline.mushroom.repository

import com.motline.mushroom.common.getRandomId
import com.motline.mushroom.common.getRandomToken
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
            id = "ncid0",
            commentId = "cid0",
            User("name", getRandomToken()),
            LocalDateTime.now(),
            contents = "@제발착해지자님 하이웨이주유소가 많은데 사진의 저기는 강서구요\n" +
                    "이번에 부천에 하나 또 열면서 행사를 여기서도 하는거죠 머 ㅋㅋ\n" +
                    "아무것도 안붙으면 default는 강서입니다",
            likeCount = 0
        )

        val y = NestedComment(
            id = "ncid1",
            commentId = "cid0",
            User("name", getRandomToken()),
            LocalDateTime.now(),
            contents = "@푸르딩딩푸딩님 아 부천점 열면서 여기도 같이 행사한다는 거군요 ㅎ\n" +
                    "근데 부천 하이웨이는 상3동 성당 옆에 있고.. 오일뱅크인데 브랜드 바꿨나부네요",
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
        val nc = nc.copy(id = getRandomId())
        this.nestedComments.add(nc)
        return nc
    }

}