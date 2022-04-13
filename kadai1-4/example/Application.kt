package com.example

import io.ktor.server.application.*
import io.ktor.server.thymeleaf.*
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver
import com.example.plugins.*
import controllers.*

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    configureRouting()
    excute()
    install(Thymeleaf){
        setTemplateResolver(ClassLoaderTemplateResolver().apply {
            prefix = "/"
            suffix = ".html"
            characterEncoding = "utf-8"
        })
    }
}
