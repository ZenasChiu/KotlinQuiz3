package com.example.quiz3_kotlin.web.model

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*

@Entity(name = "users")
class Users(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 20)
    val id : Long = 0,

    @Column(name = "username",unique = true, length = 50)
    val userName : String? = null,

    @Column(unique = true, length = 50)
    val email : String? = null,

    @Column(length = 120)
    val password : String? = null

)