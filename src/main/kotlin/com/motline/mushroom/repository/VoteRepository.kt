package com.motline.mushroom.repository

import com.motline.mushroom.model.dto.Survey
import com.motline.mushroom.model.dto.Vote
import org.springframework.stereotype.Service

@Service
class VoteRepository {

    val votes: MutableList<Vote> = mutableListOf()

    suspend fun save(vote: Vote): Vote {
        return if(this.votes.add(vote)) {
            vote
        } else {
            throw Exception("save error")
        }
    }

    suspend fun get(id: String): Vote? {
        return this.votes.find { it.id == id.toInt() }
    }

    suspend fun getAll(): List<Vote> {
        return this.votes
    }
}