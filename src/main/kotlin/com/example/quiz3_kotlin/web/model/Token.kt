package com.example.quiz3_kotlin.web.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "Token")
data class Token(
    @Id
    @Column(name = "token")
    val JWTtoken : String?=null,

    val username : String?=null,

    @Column(name = "datecreate")
    val createtime : String?=null

)