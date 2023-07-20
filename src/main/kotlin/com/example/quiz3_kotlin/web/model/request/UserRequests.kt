package com.example.quiz3_kotlin.web.model.request

import com.example.quiz3_kotlin.web.model.Users

class UserRequests {
    data class UserCreateRequest(

        val username: String,
        val password : String,
        val email : String
    )

    fun UserCreateRequest.toEntity() = Users(
        userName = username,
        password = password,
        email = email
    )

    data class UserUpdateRequest(
        val username: String,
        val password : String,
        val email : String
    )

    fun UserUpdateRequest.toEntity(id: Long) = Users(
        id = id,
        userName = username,
        password = password,
        email = email
    )
}