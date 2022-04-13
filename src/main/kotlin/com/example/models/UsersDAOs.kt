package com.example.models

import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.dao.*
import org.jetbrains.exposed.dao.id.*
import org.jetbrains.exposed.sql.*

//オブジェクト作成
object UsersDAOs:IntIdTable("Users"){
    val name = varchar("name",50)
}
//class作成
class UsersDAO(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<UsersDAO>(UsersDAOs)
    var name by UsersDAOs.name
}
fun Application.usersdao() {
    Database.connect("jdbc:mysql://127.0.0.1/test", "com.mysql.cj.jdbc.Driver", "root", "")
    routing {
        get("/users/{id}") {
            var data: String? =null
            transaction {
                val sid = call.parameters["id"]
                val i: Int = Integer.parseInt(sid)
                val userdata = UsersDAO.findById(i)
                if (userdata != null) {
                    data=userdata.name
                }
            }
            call.respondText("$data")
        }
    }
}
