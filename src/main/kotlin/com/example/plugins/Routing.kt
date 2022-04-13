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
        /*get("/form") {
            val sampleUser = User(1, "John")
            call.respond(ThymeleafContent("form", mapOf("user" to sampleUser)))
        }
        route("/result"){
            post{
                val post = call.receiveParameters()
                val na: String
                na = post["name"].toString()
                //call.respondText("$na")
                //これなに！！
                //call.respond(FreeMarkerContent("result.ftl", mapOf("name" to na),""))
                call.respond(ThymeleafContent("result", mapOf("user" to na)))

            }
        }*/
    }
}
data class User(val id: Int, val name: String)
