package com.example.plugins

import io.ktor.server.routing.*
import io.ktor.http.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.thymeleaf.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureRouting() {
    val date = LocalDateTime.now()
    val dtformat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")
    val fdate = dtformat.format(date)
    // Starting point for a Ktor app:
    routing {
        get("/hello") {
            call.respondText("Hello $fdate")
        }
        get("/hello2/{id}") {
            val id = call.parameters["id"]
            call.respondText("Hello $id")
        }
    }
}
data class User(val id: Int, val name: String)
