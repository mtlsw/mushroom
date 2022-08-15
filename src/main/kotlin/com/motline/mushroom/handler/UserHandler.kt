package com.motline.mushroom.handler

import com.motline.mushroom.model.request.NestedCommentSaveRequest
import com.motline.mushroom.model.request.UserSaveRequest
import com.motline.mushroom.service.UserService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*

@Component
class UserHandler(val userService: UserService) {

    suspend fun getUser(serverRequest: ServerRequest): ServerResponse {

        val token = serverRequest.headers().header("x-auth")
        println(token)

        if (token.isEmpty()) {
            return ServerResponse.badRequest().bodyValueAndAwait("no x-auth token")
        }

        val user = userService.getUser(token.first())

        return ServerResponse.ok().json().bodyValueAndAwait(mapOf("user" to user))
    }

    suspend fun saveUser(serverRequest: ServerRequest): ServerResponse {
        val userSaveRequest = serverRequest.awaitBody(UserSaveRequest::class)
        val savedUser = userService.saveUser(
            userSaveRequest.name,
            userSaveRequest.thirdPartyName,
            userSaveRequest.thirdPartyId
        )

        return ServerResponse.ok().json().bodyValueAndAwait(savedUser)
    }

    suspend fun main(serverRequest: ServerRequest): ServerResponse {
        return ServerResponse.ok().json().bodyValueAndAwait(mapOf("message" to "don't angry"))
    }
}