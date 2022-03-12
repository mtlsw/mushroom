package com.motline.mushroom.handler

import com.motline.mushroom.service.VoteService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.*

@Component
class MainHandler(val voteService: VoteService) {

    suspend fun info(serverRequest: ServerRequest): ServerResponse {
        return ServerResponse.ok().json().bodyValueAndAwait(mapOf("" to ""))
    }

    suspend fun dummy(serverRequest: ServerRequest): ServerResponse {
        return ServerResponse.ok().json().bodyValueAndAwait(mapOf("" to ""))
    }

    suspend fun votes(serverRequest: ServerRequest): ServerResponse {
        val votes = voteService.votes()
        println(votes)
        return ServerResponse.ok().json().bodyValueAndAwait(votes)
    }

    suspend fun vote(serverRequest: ServerRequest): ServerResponse {
        return ServerResponse.ok().json().bodyValueAndAwait(mapOf("" to ""))
    }
}