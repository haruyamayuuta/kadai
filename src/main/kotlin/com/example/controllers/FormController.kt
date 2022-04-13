package com.example.controllers

import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.thymeleaf.*
import io.ktor.server.request.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun Application.excute() {
    // Starting point for a Ktor app:
    routing {
        get("/form") {
            val sampleUser = User(1, "John")
            call.respond(ThymeleafContent("form", mapOf("user" to sampleUser)))
        }
        route("/POST/result"){
            post{
                val post = call.receiveParameters()
                val na: String = post["name"].toString()
                //call.respondText("$na")
                //これなに！！
                //call.respond(FreeMarkerContent("result.ftl", mapOf("name" to na),""))
                call.respond(ThymeleafContent("result", mapOf("user" to na)))

            }
        }
    }
}
data class User(val id: Int, val name: String)
