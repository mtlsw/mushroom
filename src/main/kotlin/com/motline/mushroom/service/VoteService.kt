package com.motline.mushroom.service

import com.motline.mushroom.model.dto.Article
import com.motline.mushroom.model.dto.Candidate
import com.motline.mushroom.model.dto.User
import com.motline.mushroom.model.dto.Vote
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import java.time.LocalDateTime

@Service
class VoteService(val webClientBuilder: WebClient.Builder) {

    suspend fun votes(): List<Vote> {

        // dummy
        return dummyVotes()
    }

    /*
    val author: User,
    val created: Long, // to datetime
    val description: String,
    val candidates: List<Candidate>?, // max 4? 5?

    val likes: List<String>, // list of user id?
    val dislikes: List<String>, // list of user id?

    val comments: List<Comment>
     */
    suspend fun dummyVotes(): List<Vote> {
        return listOf(
            Vote(
                author = User("pg160"),
                created = LocalDateTime.now(),
                description = "g90 vs e class",
                candidates = listOf(Candidate("g90"), Candidate("e class"))
            ),
        )
    }
}

