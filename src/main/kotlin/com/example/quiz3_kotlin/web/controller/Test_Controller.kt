package com.example.quiz3_kotlin.web.controller

import com.example.quiz3_kotlin.security.JwtToken
import com.example.quiz3_kotlin.services.System_Auth_Services
import com.example.quiz3_kotlin.services.System_Test_Services
import jakarta.security.auth.message.AuthException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/test")
class Test_Controller(
    @Autowired
    val jwtToken: JwtToken,
    //@Autowired
    //val system_test_services: System_Test_Services
) {


    @GetMapping("/all")
    fun getPublicContent(){

    }
    @GetMapping("/user")
    fun getUserContent(@RequestHeader("Authorization") au:String) : ResponseEntity<String>{
        val token : String = au.substring(6);
        try {
            jwtToken.validateToken(token);
        } catch (e : AuthException) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.toString())
        }
        return ResponseEntity.status(HttpStatus.OK).body("access OK");
    }


    @GetMapping("/mod")
    fun getModContent(){

    }
    @GetMapping("/admin")
    fun getAdminContent(){

    }

}