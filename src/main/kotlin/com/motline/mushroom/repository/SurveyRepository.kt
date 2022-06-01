package com.motline.mushroom.repository

import com.motline.mushroom.model.dto.Survey
import com.motline.mushroom.model.dto.User
import com.motline.mushroom.model.dto.Vote
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class SurveyRepository {

    private final val votes: MutableList<Survey> = mutableListOf()

    init {

        val vote = Vote(
            label = "xx",
            thumbnail = "",
            voted = 0
        )

        val votes = (0 .. 5).map { i ->
            vote.copy(label = "$vote 1", voted = i)
        }

        val survey = Survey(
            user = User("hi"),
            created = LocalDateTime.now(),
            contents = "hi",
            votes = votes,
            likeCount = 0,
            commentCount = 0,
            currentUserReaction = false
        )

        this.votes.add(survey)
    }
    suspend fun save(survey: Survey): Survey {
        return if(this.votes.add(survey)) {
            survey
        } else {
            throw Exception("save error")
        }
    }

    suspend fun get(id: Int): Survey? {
        return this.votes.find { it.id == id }
    }

    suspend fun getAll(): List<Survey> {
        return this.votes
    }
}