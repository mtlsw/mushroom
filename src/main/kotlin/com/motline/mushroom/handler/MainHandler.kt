package com.motline.mushroom.handler

import com.motline.mushroom.model.request.VoteSaveRequest
import com.motline.mushroom.service.VoteService
import org.springframework.stereotype.Component
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
        val votes = voteService.getAll()
        println(votes)
        return ServerResponse.ok().json().bodyValueAndAwait(votes)
    }

    suspend fun getVote(serverRequest: ServerRequest): ServerResponse {
        val id = serverRequest.queryParamOrNull("id")

        if (id != null)  {
            val vote = voteService.get(id)
            println(vote)
            return ServerResponse.ok().json().bodyValueAndAwait(vote!!)
        } else {
            throw Exception("id null")
        }
    }

    suspend fun saveVote(serverRequest: ServerRequest): ServerResponse {
        val saveRequest = serverRequest.awaitBody<VoteSaveRequest>()
        val vote = voteService.save(saveRequest.toVote())
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