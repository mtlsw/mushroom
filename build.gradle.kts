import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.6.3"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("com.google.cloud.tools.jib") version "3.2.1"
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.spring") version "1.6.10"
}

group = "com.motline"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    implementation("io.netty:netty-resolver-dns-native-macos:4.1.77.Final:osx-aarch_64")
    implementation("org.springdoc:springdoc-openapi-ui:1.6.9")
    implementation("org.springdoc:springdoc-openapi-webflux-ui:1.6.9")
    implementation("org.springdoc:springdoc-openapi-kotlin:1.6.9")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks {
    jib {
        from {
            image = "eclipse-temurin:17-jre"
//            platforms {
//                platform {
//                    architecture = "arm64"
//                    os = "linux"
//                }
//            }
        }
        to {
//            image = "655534681351.dkr.ecr.ap-northeast-2.amazonaws.com/${project.name}-${project.version.toString().toLowerCase()}"

            image = "gcr.io/tfit-271908/mushroom"
            tags = mutableSetOf("latest")

        }
        container {
            creationTime = "USE_CURRENT_TIMESTAMP"
            jvmFlags = mutableListOf("-Dspring.profiles.active=local", "-XX:+UseContainerSupport", "-Dserver.port=8080", "-Dfile.encoding=UTF-8")
            ports = mutableListOf("8080")
//            labels = [maintainer: "x <x@gmail.com>"]
        }
    }
}