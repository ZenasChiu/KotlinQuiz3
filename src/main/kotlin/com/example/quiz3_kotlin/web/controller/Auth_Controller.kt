package com.example.quiz3_kotlin.web.controller

import com.example.quiz3_kotlin.services.System_Auth_Services
import com.example.quiz3_kotlin.web.model.Roles
import com.example.quiz3_kotlin.web.model.UserDTO
import com.example.quiz3_kotlin.web.model.Users

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/auth")
class Auth_Controller {
    @Autowired
    var system_auth_services: System_Auth_Services? = null


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
    fun userSignIn(@RequestBody userDTO: UserDTO): ResponseEntity<String>{
        var header:String = stringHeader(system_auth_services?.userSignIn(userDTO))

        return ResponseEntity.ok(header)
    }
    @PostMapping("/signout")
    fun userSignOut(){
        TODO("Token Get & Disable")
        //Token disable
    }


}