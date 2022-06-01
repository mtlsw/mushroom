package com.motline.mushroom.service

import com.motline.mushroom.model.dto.Survey
import com.motline.mushroom.repository.VoteRepository
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class VoteService(
    val webClientBuilder: WebClient.Builder,
    val voteRepository: VoteRepository

    ) {

    suspend fun getAll(): List<Survey> {
        return voteRepository.getAll()
    }

    suspend fun get(id: String): Survey? {
        return voteRepository.get(id)
    }

    suspend fun save(vote: Survey): Survey? {
        return voteRepository.save(vote)
    }
}

/*
suspend fun get(id: String): Vote? {
        return this.votes.find { it.id == id }
    }
 */