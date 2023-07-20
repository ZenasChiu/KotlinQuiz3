package com.example.quiz3_kotlin.services

import com.example.quiz3_kotlin.web.model.UserDTO

interface System_Auth_Services {
    fun userSignUp(userDTO: UserDTO): Boolean
    fun userSignIn(userDTO: UserDTO): Boolean
}