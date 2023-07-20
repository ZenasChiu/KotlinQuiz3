package com.example.quiz3_kotlin.repository

import com.example.quiz3_kotlin.web.model.Users
import com.example.quiz3_kotlin.web.model.mapper.UserMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class UserRepository(@Autowired val jdbcTemplate: JdbcTemplate) {
    fun createUser(users: Users){
        jdbcTemplate.update("INSERT INTO users(email, password, username) "
                + "VALUES (?,?,?)",users.email,users.password,users.userName);
        }
    fun getmap(item : String, search : Any) : Users? {
        val sql = "SELECT * FROM users WHERE $item = ?"
        return jdbcTemplate.queryForObject(sql, arrayOf<Any>(search), UserMapper())
    }
    fun getUserById(id : Long) : Users? {
        return getmap("id",id)
    }
    fun getUserByName(username : String) : Users? {
        return getmap("username",username)
    }
    fun getUserByEmail(email : String) : Users? {
        return getmap("email",email)
    }

    fun userExists(id : Long) : Boolean{

        return false
    }
    fun userExists(id : Long, name: String?, email: String?) : Boolean{
        return false
    }
}