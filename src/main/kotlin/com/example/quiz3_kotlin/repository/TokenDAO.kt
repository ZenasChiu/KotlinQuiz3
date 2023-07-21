package com.example.quiz3_kotlin.repository

import com.example.quiz3_kotlin.web.model.Token
import jakarta.security.auth.message.AuthException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate

import org.springframework.stereotype.Repository
import java.sql.SQLException

@Repository
class TokenDAO(@Autowired val jdbcTemplate: JdbcTemplate) {
    fun createToken(token: Token){
        jdbcTemplate.update("INSERT INTO token(token,datecreate, username) "
                + "VALUES (?,?,?)",token.JWTtoken,token.createtime,token.username);
    }
    fun removeToken(token: String){
        try{
        jdbcTemplate.update("DELETE FROM token WHERE token = ?",token)
        }
        catch(e : SQLException)
        {throw AuthException("No record")}
    }
    fun checkToken(token: String?) : Boolean{
        try {
            jdbcTemplate.execute("select token FROM token WHERE token = \"$token\"")
            return true}
        catch(e : SQLException)
        {throw AuthException("No record")}
    }
}