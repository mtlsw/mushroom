package com.motline.mushroom.handler

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*

@Component
class MainHandler() {

    suspend fun info(serverRequest: ServerRequest): ServerResponse {
        return ServerResponse.ok().json().bodyValueAndAwait(mapOf("" to ""))
    }

    suspend fun dummy(serverRequest: ServerRequest): ServerResponse {
        return ServerResponse.ok().json().bodyValueAndAwait(mapOf("" to ""))
    }
}