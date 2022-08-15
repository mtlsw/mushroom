package com.motline.mushroom.handler

import com.motline.mushroom.common.pageableResponse
import com.motline.mushroom.model.request.CommentSaveRequest
import com.motline.mushroom.service.CommentService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*

@Component
class CommentHandler(val commentService: CommentService) {
    suspend fun saveComment(serverRequest: ServerRequest): ServerResponse {
        val contents = serverRequest.awaitBody(CommentSaveRequest::class).contents
        val surveyId = serverRequest.pathVariable("id")

        val comment = commentService.save(contents, surveyId)

        // TODO
        return ServerResponse.ok().json().bodyValueAndAwait(mapOf("error" to "", "result" to comment))
    }

    suspend fun updateComment(serverRequest: ServerRequest): ServerResponse {
        val contents = serverRequest.awaitBody(CommentSaveRequest::class).contents
        val surveyId = serverRequest.pathVariable("id")

        val comment = commentService.save(contents, surveyId)

        // TODO
        return ServerResponse.ok().json().bodyValueAndAwait(mapOf("error" to "", "result" to comment))
    }

    suspend fun getComments(serverRequest: ServerRequest): ServerResponse {
        val surveyId = serverRequest.pathVariable("id") as String

        val comments = commentService.getAll(surveyId)
        return ServerResponse.ok().json().bodyValueAndAwait(pageableResponse(comments))
    }
}