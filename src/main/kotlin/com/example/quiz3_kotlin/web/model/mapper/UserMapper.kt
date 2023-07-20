package com.example.quiz3_kotlin.web.model.mapper

import com.example.quiz3_kotlin.web.model.Users
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet
import java.sql.SQLException

class UserMapper : RowMapper<Users> {
    @Throws(SQLException::class)
    override fun mapRow(rs: ResultSet, rowNum: Int): Users {
        val users = Users(
            email = rs.getString("email"),
            password = rs.getString("password"),
            userName = rs.getString("username"),
            id = rs.getInt("id").toLong())

        return users
    }
}