package com.example.quiz3_kotlin.web.controller

import com.example.quiz3_kotlin.security.JwtToken
import com.example.quiz3_kotlin.services.System_Auth_Services
import com.example.quiz3_kotlin.web.model.Roles
import com.example.quiz3_kotlin.web.model.UserDTO
import com.example.quiz3_kotlin.web.model.Users

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.http.ResponseEntity as ResponseEntity

@RestController
@RequestMapping("/api/auth")
class Auth_Controller(
    @Autowired
    var system_auth_services: System_Auth_Services,
) {



    fun stringHeader( tf : Boolean?) : String {
        var header : String =""
        when(tf){
            true -> header = "Message : Done"
            false -> header = "Message : Not Done"
            else -> header = "Message : "
        }
        return header
    }
    @PostMapping("/signup")
    fun userSignUp(@RequestBody userDTO: UserDTO) : UserDTO{
        system_auth_services?.userSignUp(userDTO)
        return userDTO
    }

    @PostMapping("/signin")
    fun userSignIn(@RequestBody userDTO: UserDTO): ResponseEntity<String> {
        var token:String = system_auth_services?.userSignIn(userDTO).toString()

        return ResponseEntity.status(HttpStatus.OK).body(token)
    }
    @PostMapping("/signout")
    fun userSignOut(){
        TODO("Token Get & Disable")
        //Token disable
    }


}