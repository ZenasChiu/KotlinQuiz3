package com.example.quiz3_kotlin.web.controller

import com.example.quiz3_kotlin.services.System_Auth_Services
import com.example.quiz3_kotlin.web.model.UserDTO
import jakarta.security.auth.message.AuthException
import jakarta.servlet.http.Cookie
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


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
    fun userSignIn(@RequestBody userDTO: UserDTO, response: HttpServletResponse, request: HttpServletRequest): ResponseEntity<Any>{
        var token = system_auth_services?.userSignIn(userDTO)

        val cookie = Cookie(userDTO.userName, token.toString())
        cookie.path = "/api"
        cookie.isHttpOnly = true
        response.addCookie(cookie)
        response.addHeader("Authorization", token);

        return ResponseEntity.ok(token)

    }
    @PostMapping("/signout")
    fun userSignOut(request: HttpServletRequest): ResponseEntity<Any> {
        val cookies = request.cookies
        for (c: Cookie in cookies) {
            val token: String = c.value
            try {
                system_auth_services.userSignout(token)
                return ResponseEntity.status(HttpStatus.OK).body("Sign out done")

            } catch (e: AuthException) {
                //jwtToken.checkToken(token)
                return ResponseEntity.status(HttpStatus.OK).body(e.message)
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body("error")
    }


}