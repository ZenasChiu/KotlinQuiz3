package com.example.quiz3_kotlin

import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.springframework.stereotype.Component


@Aspect
@Component
class ServiceAspect {
    @Pointcut("execution(public * com.example.quiz3_kotlin.service.*.*(..))")
    fun pointcut() {}

    @Before("pointcut()")
    fun before(){
        println("Before Service Start")
    }

    @After("pointcut()")
    fun After(){
        println("After Service Done")
    }
}