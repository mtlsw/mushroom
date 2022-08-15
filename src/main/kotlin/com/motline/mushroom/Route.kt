package com.motline.mushroom

import com.motline.mushroom.handler.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class Route {

    @Bean
    fun routes(surveyHandler: SurveyHandler,
               someHandler: SomeHandler,
               commentHandler: CommentHandler,
               userHandler: UserHandler,
               nestedCommentHandler: NestedCommentHandler): RouterFunction<*> = coRouter {
        accept(MediaType.APPLICATION_JSON).nest {
            "/".nest {
                GET("", someHandler::main)
            }
            "/api".nest {
                GET("/info", someHandler::info)
            }

            "/api/user".nest {
                GET("", userHandler::getUser)
            }
            "/api/surveys".nest {
                GET("/", surveyHandler::getSurveys)
                GET("", surveyHandler::getSurveys)
                POST("/", surveyHandler::saveSurvey)
                POST("", surveyHandler::saveSurvey)
//                PUT()
                GET("/{id}", surveyHandler::getSurvey)

                GET("/{id}/comments", commentHandler::getComments)
//                GET("/{id}/comments/{comment=Id}", commentHandler::getComments)
                POST("/{id}/comment", commentHandler::saveComment)
                PUT("/{id}/comment", commentHandler::updateComment)

                GET("/{id}/comments/{commentId}", nestedCommentHandler::gets)
//                GET("/{id}/comments/{commentId}", commentHandler::getComments)
                POST("/{id}/comment/{commentId}", nestedCommentHandler::save)

                POST("{articleId}/like", surveyHandler::like)
                POST("{articleId}/dislike", surveyHandler::dislike)
            }
        }
    }
}
