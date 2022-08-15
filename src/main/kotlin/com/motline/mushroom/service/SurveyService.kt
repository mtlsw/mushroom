package com.motline.mushroom.service

import com.motline.mushroom.model.dto.Reaction
import com.motline.mushroom.model.dto.Survey
import com.motline.mushroom.repository.ReactionRepository
import com.motline.mushroom.repository.SurveyRepository
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class SurveyService(
    val webClientBuilder: WebClient.Builder,
    val surveyRepository: SurveyRepository,
    val commentService: CommentService,
    val reactionRepository: ReactionRepository

    ) {

    suspend fun getAll(category: String?, keyword: String?): List<Survey> {
        return surveyRepository.getAll(category, keyword)
    }

    suspend fun get(id: String): Survey? {
        val survey = surveyRepository.get(id)
        val comments = commentService.getAll(id)
        return survey?.copy(commentCount = comments.size)
    }

    suspend fun save(vote: Survey): Survey? {
        return surveyRepository.save(vote)
    }

    suspend fun reaction(reaction: Reaction): Reaction? {
        return reactionRepository.save(reaction)
    }
}

/*
suspend fun get(id: String): Vote? {
        return this.votes.find { it.id == id }
    }
 */