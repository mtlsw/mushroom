package com.motline.mushroom.model.dto

data class User(
    val name: String,
    val sessionToken: String,
    val thirdPartyLinks: Map<String, String> = emptyMap(),

    val id: String? = null,
    val token: String? = null,
    val refreshToken: String? = null
)