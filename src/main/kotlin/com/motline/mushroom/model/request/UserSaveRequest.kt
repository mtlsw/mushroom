package com.motline.mushroom.model.request

data class UserSaveRequest(
    val name: String,
    val thirdPartyName: String, // google, kakao 같은거
    val thirdPartyId: String // google id 같은거
)