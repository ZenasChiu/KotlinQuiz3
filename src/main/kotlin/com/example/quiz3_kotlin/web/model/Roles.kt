package com.example.quiz3_kotlin.web.model

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*

@Entity
data class Roles(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 20)

    val  id: Int? = null,

    @Column(length = 20)
    @JsonProperty("roles")
    val name: String? = null
)






