package com.motline.mushroom

import com.motline.mushroom.handler.CommentHandler
import com.motline.mushroom.handler.SurveyHandler
import com.motline.mushroom.handler.NestedCommentHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class Route {

    @Bean
    fun routes(surveyHandler: SurveyHandler,
               commentHandler: CommentHandler,
               nestedCommentHandler: NestedCommentHandler): RouterFunction<*> = coRouter {
        accept(MediaType.APPLICATION_JSON).nest {
            "/api".nest {
                GET("/info", surveyHandler::info)
            }

            "/api/surveys".nest {
                GET("/", surveyHandler::getSurveys)
                GET("", surveyHandler::getSurveys)
                POST("/", surveyHandler::saveSurvey)
                POST("", surveyHandler::saveSurvey)
                POST("/survey", surveyHandler::saveSurvey)
//                PUT()

                GET("/{id}", surveyHandler::getSurvey)


                GET("/{id}/comments", commentHandler::getComments)
//                GET("/{id}/comments/{commentId}", commentHandler::getComments)
                POST("/{id}/comment", commentHandler::saveComment)

                GET("/{id}/comments/{commentId}", nestedCommentHandler::gets)
//                GET("/{id}/comments/{commentId}", commentHandler::getComments)
                POST("/{id}/comment/{commentId}", nestedCommentHandler::save)



                POST("{articleId}/like", surveyHandler::like)
                POST("{articleId}/dislike", surveyHandler::dislike)
            }
        }
    }
}
