package com.motline.mushroom

import com.motline.mushroom.handler.MainHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.coRouter

/*
POST        /api/v2/skill/test                            controllers.v2.SkillController.testSkill
POST        /api/v2/skill/exec/:actionId                  controllers.v2.SkillController.executeSkillByActionId(actionId)
POST        /api/v2/skill/format                          controllers.v2.SkillController.format
POST        /api/v2/validate/param                        controllers.v2.ValidateController.validateParam

 */
@Configuration
class Route {

    @Bean
    fun routes(mainHandler: MainHandler): RouterFunction<*> = coRouter {
        accept(MediaType.APPLICATION_JSON).nest {
            "/api".nest {
                GET("/info", mainHandler::info)
                GET("/votes", mainHandler::votes)
                GET("/vote/{id}", mainHandler::vote)
                POST("/dummy", mainHandler::dummy)
            }
        }
    }
}
