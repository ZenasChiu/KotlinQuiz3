package com.example.quiz3_kotlin.web.model

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.Column


data class UserDTO (
    @JsonProperty("id")
    val id : Long = 0,

    @JsonProperty("username")
    val userName : String? = null,

    @JsonProperty("email")
    val email : String? = null,

    @JsonProperty("password")
    @Column(length = 120)
    val password : String? = null,

    @JsonProperty("roles")
    val roles : Set<String>? = null
)