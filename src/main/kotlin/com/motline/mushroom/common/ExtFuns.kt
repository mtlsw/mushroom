package com.motline.mushroom.common

fun pagableResposne(data: List<Any>): Map<String, Any> {
    return mapOf(
        "data" to data,
        "totalCount" to data.size, // pagination 하면 달라질 수 있음.
        "currPage" to 0,
        "nextPage" to false
    )
}
