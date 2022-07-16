package com.motline.mushroom.handler

import com.motline.mushroom.common.pagableResposne
import com.motline.mushroom.model.request.SurveySaveRequest
import com.motline.mushroom.service.SurveyService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*

@Component
class SurveyHandler(
    val surveyService: SurveyService
    ) {

    suspend fun info(serverRequest: ServerRequest): ServerResponse {
        return ServerResponse.ok().json().bodyValueAndAwait(mapOf("" to ""))
    }

    suspend fun dummy(serverRequest: ServerRequest): ServerResponse {
        return ServerResponse.ok().json().bodyValueAndAwait(mapOf("" to ""))
    }

    suspend fun getSurveys(serverRequest: ServerRequest): ServerResponse {
        val category = serverRequest.queryParamOrNull("category")
        val keyword = serverRequest.queryParamOrNull("keyword")
        val surveys = surveyService.getAll(category = category, keyword = keyword)
        println(surveys)
        val res =pagableResposne(surveys)

        return ServerResponse.ok().json().bodyValueAndAwait(res)
    }

    suspend fun getSurvey(serverRequest: ServerRequest): ServerResponse {
        val surveyId = serverRequest.queryParamOrNull("id")

        if (surveyId != null)  {
            val survey = surveyService.get(surveyId)
            println(survey)
            return ServerResponse.ok().json().bodyValueAndAwait(survey!!)
        } else {
            throw Exception("id null")
        }
    }

    suspend fun saveSurvey(serverRequest: ServerRequest): ServerResponse {
        val saveRequest = serverRequest.awaitBody<SurveySaveRequest>()
        val vote = surveyService.save(saveRequest.toSurvey())
        println(vote)
        return ServerResponse.ok().json().bodyValueAndAwait(vote!!)
    }


    /*
    (path-variable) string
(query-string) keyword?: (querystring) string
(query-string) order: ‘thumbUp’ | ‘ thumbDown’ | ‘lastest’
(query-string) page: number
     */

    suspend fun like(serverRequest: ServerRequest): ServerResponse {
        return ServerResponse.ok().json().bodyValueAndAwait(mapOf("" to ""))
    }

    suspend fun dislike(serverRequest: ServerRequest): ServerResponse {
        return ServerResponse.ok().json().bodyValueAndAwait(mapOf("" to ""))
    }


}