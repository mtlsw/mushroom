package com.motline.mushroom.handler

import com.motline.mushroom.model.request.SurveySaveRequest
import com.motline.mushroom.service.SurveyService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*

@Component
class MainHandler(val surveyService: SurveyService) {

    suspend fun info(serverRequest: ServerRequest): ServerResponse {
        return ServerResponse.ok().json().bodyValueAndAwait(mapOf("" to ""))
    }

    suspend fun dummy(serverRequest: ServerRequest): ServerResponse {
        return ServerResponse.ok().json().bodyValueAndAwait(mapOf("" to ""))
    }

    suspend fun surveys(serverRequest: ServerRequest): ServerResponse {
        val surveys = surveyService.getAll()
        println(surveys)
        val res = mapOf(
            "data" to surveys,
            "totalCount" to surveys.size,
            "currPage" to 0,
            "nextPage" to false
        )
        return ServerResponse.ok().json().bodyValueAndAwait(res)
    }

    suspend fun survey(serverRequest: ServerRequest): ServerResponse {
        val id = serverRequest.queryParamOrNull("id")

        if (id != null)  {
            val survey = surveyService.get(id)
            println(survey)
            return ServerResponse.ok().json().bodyValueAndAwait(survey!!)
        } else {
            throw Exception("id null")
        }
    }

    suspend fun saveVote(serverRequest: ServerRequest): ServerResponse {
        val saveRequest = serverRequest.awaitBody<SurveySaveRequest>()
        val vote = surveyService.save(saveRequest.toSurvey())
        println(vote)
        return ServerResponse.ok().json().bodyValueAndAwait(vote!!)
    }

    suspend fun saveComment(serverRequest: ServerRequest): ServerResponse {
        return ServerResponse.ok().json().bodyValueAndAwait(mapOf("" to ""))
    }

    suspend fun like(serverRequest: ServerRequest): ServerResponse {
        return ServerResponse.ok().json().bodyValueAndAwait(mapOf("" to ""))
    }

    suspend fun dislike(serverRequest: ServerRequest): ServerResponse {
        return ServerResponse.ok().json().bodyValueAndAwait(mapOf("" to ""))
    }
}