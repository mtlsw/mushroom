package com.motline.mushroom.repository

import com.motline.mushroom.common.getRandomId
import com.motline.mushroom.model.dto.Survey
import com.motline.mushroom.model.dto.User
import com.motline.mushroom.model.dto.Vote
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import kotlin.random.Random

@Service
class SurveyRepository {

    private final val surveys: MutableList<Survey> = mutableListOf()

    init {

        val ranText = listOf("피고인의 자백이 고문·폭행·협박·구속의 부당한 장기화 또는 기망 기타의 방법에 의하여 자의로 진술된 것이 아니라고 인정될 때 또는 정식재판에 있어서 피고인의 자백이 그에게 불리한 유일한 증거일 때에는 이를 유죄의 증거로 삼거나 이를 이유로 처벌할 수 없다.",
            "이 헌법중 공무원의 임기 또는 중임제한에 관한 규정은 이 헌법에 의하여 그 공무원이 최초로 선출 또는 임명된 때로부터 적용한다. 근로조건의 기준은 인간의 존엄성을 보장하도록 법률로 정한다.",
            "산야에 청춘의 살 하여도 하는 사막이다. 황금시대를 풀이 청춘 수 불어 있으며, 힘차게 인도하겠다는 불어 피다. 기관과 그들은 우리의 있을 보배를 열매를 봄바람이다. 소담스러운 미묘한 꽃이 이것이다. 공자는 지혜는 어디 간에 풍부하게 무엇이 밝은 보배를 있으랴? 아니한 들어 곳이 청춘의 돋고, 위하여서 가슴이 뿐이다. 오아이스도 그들에게 있음으로써 힘차게 청춘의 약동하다. 않는 부패를 있으며, 위하여 얼음에 무한한 있다. 때에, 이상, 기쁘며, 긴지라 피다.",
            "힘차게 피부가 청춘에서만 크고 피가 말이다. 품었기 원질이 커다란 때까지 커다란 우는 칼이다. 그들에게 군영과 싸인 천자만홍이 가슴이 있으랴? 보이는 두손을 장식하는 끓는 인도하겠다는 넣는 부패를 싸인 것이다. 이상은 들어 얼음이 구하지 귀는 불러 바이며, 뿐이다. 가장 있으며, 뭇 이상은 눈이 사막이다. 무엇을 거선의 살 내려온 봄바람이다. 방황하였으며, 같은 황금시대의 듣는다. 꽃이 실로 풍부하게 같으며, 인류의 넣는 듣기만 원대하고, 길을 교향악이다."
        )
        val vote = Vote(
            label = "xx",
            thumbnail = "https://image.musinsa.com/mfile_s01/2021/11/26/baf76429a02a9aab640eaee3baa787eb164756.jpg",
            vote = 0
        )

        val votes = (0 .. 2).map { i ->
            vote.copy(label = "$vote 1", vote = i, id = getRandomId())
        }

        val survey = Survey(
            id = "sid0",
            user = User("hi"),
            created = LocalDateTime.now(),
            contents = ranText.random(),
            votes = votes,
            likeCount = 0,
            commentCount = 0,
            currentUserReaction = false
        )

        this.surveys.add(survey)
    }
    suspend fun save(survey: Survey): Survey {
        val s = survey.copy(id = getRandomId())
        return if(this.surveys.add(s)) {
            s
        } else {
            throw Exception("save error")
        }
    }

    suspend fun get(id: String): Survey? {
        return this.surveys.find { it.id == id }
    }

    suspend fun getAll(category: String?, keyword: String?): List<Survey> {
        // filtering
        return this.surveys
    }
}