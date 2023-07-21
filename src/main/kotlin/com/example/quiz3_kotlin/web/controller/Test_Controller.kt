package com.example.quiz3_kotlin.web.controller

import com.example.quiz3_kotlin.security.JwtToken
import jakarta.security.auth.message.AuthException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.Cookie
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
    fun getUserContent(request: HttpServletRequest): ResponseEntity<Any>{
        val cookies = request.cookies
        var message : String ="error"
        for(c : Cookie in cookies){
            val token : String = c.value
            try {
                jwtToken.validateToken(token);
                return ResponseEntity.status(HttpStatus.OK).body("access OK");
            } catch (e : AuthException) {
                //jwtToken.checkToken(token)
                message =e.message.toString()
            }
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(message)
    }


    @GetMapping("/mod")
    fun getModContent(){

    }
    @GetMapping("/admin")
    fun getAdminContent(){

    }

}