package com.example.quiz3_kotlin.web.controller

import com.example.quiz3_kotlin.services.System_Auth_Services
import com.example.quiz3_kotlin.services.System_Test_Services
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/test")
class Test_Controller {

    @Autowired
    var system_test_services: System_Test_Services? = null

    @GetMapping("/all")
    fun getPublicContent(){

    }
    @GetMapping("/user")
    fun getUserContent(){

    }
    @GetMapping("/mod")
    fun getModContent(){

    }
    @GetMapping("/admin")
    fun getAdminContent(){

    }
}