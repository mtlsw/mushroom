package com.motline.mushroom.service

import com.motline.mushroom.model.dto.Survey
import com.motline.mushroom.repository.SurveyRepository
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class SurveyService(
    val webClientBuilder: WebClient.Builder,
    val surveyRepository: SurveyRepository

    ) {

    suspend fun getAll(): List<Survey> {
        return surveyRepository.getAll()
    }

    suspend fun get(id: String): Survey? {
        return surveyRepository.get(id.toInt())
    }

    suspend fun save(vote: Survey): Survey? {
        return surveyRepository.save(vote)
    }
}

/*
suspend fun get(id: String): Vote? {
        return this.votes.find { it.id == id }
    }
 */