package com.motline.mushroom.handler

import com.motline.mushroom.common.pagableResposne
import com.motline.mushroom.service.CommentService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*

@Component
class CommentHandler(val commentService: CommentService) {
    suspend fun saveComment(serverRequest: ServerRequest): ServerResponse {
        val contents = serverRequest.queryParamOrNull("contents") as String
        val surveyId = serverRequest.queryParamOrNull("surveyId") as String

        val comment = commentService.save(contents, surveyId)

        // TODO
        return ServerResponse.ok().json().bodyValueAndAwait(mapOf("error" to "", "result" to comment))
    }

    suspend fun getComments(serverRequest: ServerRequest): ServerResponse {
        val surveyId = serverRequest.queryParamOrNull("id") as String

        val comments = commentService.getAll(surveyId)
        return ServerResponse.ok().json().bodyValueAndAwait(pagableResposne(comments))
    }
}