package com.motline.mushroom.common

import com.fasterxml.jackson.annotation.ObjectIdGenerators.UUIDGenerator
import java.util.UUID
import kotlin.random.Random

fun pageableResponse(data: List<Any>): Map<String, Any> {
    return mapOf(
        "data" to data,
        "totalCount" to data.size, // pagination 하면 달라질 수 있음.
        "currPage" to 0,
        "nextPage" to false
    )
}

fun getRandomId() = Random.nextLong(100000000).toString()
fun getRandomToken() = UUID.randomUUID().toString()
