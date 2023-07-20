package com.example.quiz3_kotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(
	"com.example.quiz3_kotlin",
	"com.example.quiz3_kotlin.web.model",
	"com.example.quiz3_kotlin.web.controller",
	"com.example.quiz3_kotlin.services",
	"com.example.quiz3_kotlin.repository"
)
@EntityScan(
	"com.example.quiz3_kotlin",
	"com.example.quiz3_kotlin.web.model",
	"com.example.quiz3_kotlin.web.controller",
	"com.example.quiz3_kotlin.services",
	"com.example.quiz3_kotlin.repository"
)
class Quiz3KotlinApplication

fun main(args: Array<String>) {
	runApplication<Quiz3KotlinApplication>(*args)
}
