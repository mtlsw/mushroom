package com.motline.mushroom.repository

import com.motline.mushroom.model.dto.Survey
import org.springframework.stereotype.Service

@Service
class VoteRepository {

    val votes: MutableList<Survey> = mutableListOf()

    suspend fun save(survey: Survey): Survey {
        return if(this.votes.add(survey)) {
            survey
        } else {
            throw Exception("save error")
        }
    }

    suspend fun get(id: String): Survey? {
        return this.votes.find { it.id == id }
    }

    suspend fun getAll(): List<Survey> {
        return this.votes
    }
}