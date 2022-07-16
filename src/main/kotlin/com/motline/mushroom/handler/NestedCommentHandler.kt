package com.motline.mushroom.handler

import com.motline.mushroom.common.pageableResponse
import com.motline.mushroom.model.request.NestedCommentSaveRequest
import com.motline.mushroom.service.NestedCommentService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*

@Component
class NestedCommentHandler(val nestedCommentService: NestedCommentService) {
    suspend fun save(serverRequest: ServerRequest): ServerResponse {
        val surveyId = serverRequest.pathVariable("id")
        val commentId = serverRequest.pathVariable("commentId")
        val contents = serverRequest.awaitBody(NestedCommentSaveRequest::class).contents

        val comment = nestedCommentService.save(surveyId, commentId, contents = contents)

        // TODO
        return ServerResponse.ok().json().bodyValueAndAwait(mapOf("error" to "", "result" to comment))
    }

    suspend fun gets(serverRequest: ServerRequest): ServerResponse {
        val commentId = serverRequest.pathVariable("commentId")
        val page = serverRequest.queryParamOrNull("page")

        val comments = nestedCommentService.getAll(commentId)
        return ServerResponse.ok().json().bodyValueAndAwait(pageableResponse(comments))
    }

}