package com.motline.mushroom.repository

import com.motline.mushroom.common.getRandomId
import com.motline.mushroom.model.dto.Comment
import com.motline.mushroom.model.dto.Reaction
import org.springframework.stereotype.Component

@Component
class ReactionRepository {

    private final val reactions: MutableList<Reaction> = mutableListOf()

    suspend fun get(reactionId: String): Reaction? {
        return reactions.find { it.id == reactionId }
    }

    suspend fun getAll(targetId: String): List<Reaction> {
        return reactions.filter { it.targetId == targetId }
    }

    suspend fun save(r: Reaction): Reaction {
        val savedReaction = r.copy(id = getRandomId())
        reactions.add(savedReaction)
        return savedReaction
    }

}