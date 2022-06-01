package com.motline.mushroom

import com.motline.mushroom.handler.MainHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class Route {

    @Bean
    fun routes(mainHandler: MainHandler): RouterFunction<*> = coRouter {
        accept(MediaType.APPLICATION_JSON).nest {
            "/api".nest {
                GET("/info", mainHandler::info)
            }

            "/api/surveys".nest {
                GET("/", mainHandler::surveys)
                GET("/{id}", mainHandler::survey)
                POST("/vote", mainHandler::saveVote)
                POST("/{articleId}/comment", mainHandler::saveComment)
                POST("{articleId}/like", mainHandler::like)
                POST("{articleId}/dislike", mainHandler::dislike)
            }
        }
    }
}
