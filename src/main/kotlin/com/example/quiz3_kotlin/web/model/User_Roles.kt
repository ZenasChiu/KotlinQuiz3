package com.example.quiz3_kotlin.web.model

import jakarta.persistence.*

@Entity
data class User_Roles(

    @Id
    @Column(length = 20)
    val userId : Long? = null,

    @Id
    @Column(length = 11)
    val rolesId : Int? = null
)