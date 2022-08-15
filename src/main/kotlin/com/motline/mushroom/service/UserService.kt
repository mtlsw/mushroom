package com.motline.mushroom.service

import com.motline.mushroom.common.getRandomToken
import com.motline.mushroom.model.dto.User
import com.motline.mushroom.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {

    suspend fun getUser(sessionToken: String): User? {
    // token을 풀어본다. id를 찾는다.
    // 내부 user 디비 뒤진다.
        // 있으면 리턴, 없으면 구글 등 API 호출
        // 아무튼 응답.
        return userRepository.find(sessionToken)
    }

    suspend fun saveUser(name: String): User {
        val a = User(
            name,
            getRandomToken()
        )
        return userRepository.save(a)
    }
}