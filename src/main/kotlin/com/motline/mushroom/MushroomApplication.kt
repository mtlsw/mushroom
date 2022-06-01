package com.motline.mushroom

import io.swagger.v3.oas.models.info.Info
import org.springdoc.core.GroupedOpenApi
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class MushroomApplication

fun main(args: Array<String>) {
    runApplication<MushroomApplication>(*args)
}
