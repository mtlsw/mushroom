package com.motline.mushroom.repository

import com.motline.mushroom.common.getRandomId
import com.motline.mushroom.common.getRandomToken
import com.motline.mushroom.model.dto.User
import org.springframework.stereotype.Component

@Component
class UserRepository {

    private final val users: MutableList<User> = mutableListOf()

    init {
        val x = User(
            name = "a",
            sessionToken = getRandomToken()
        )
        this.users.add(x)
    }

    suspend fun find(sessionToken: String): User? {
        return users.find { it.sessionToken == sessionToken }
    }

    suspend fun save(u: User): User {
        val savedUser = u.copy(id = getRandomId())
        users.add(savedUser)
        return savedUser
    }
}