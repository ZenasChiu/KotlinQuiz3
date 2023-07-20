package com.example.quiz3_kotlin.security

import org.junit.jupiter.api.*

import org.junit.jupiter.api.Assertions.*
import java.security.MessageDigest

class EncryptionMD5Test {

    fun en(p:String) : String{
        val digest = MessageDigest.getInstance("MD5")
        val result = digest.digest(p.toByteArray())
        return toHex(result)
    }
    fun toHex(byteArray: ByteArray): String {
        val result = with(StringBuilder()) {
            byteArray.forEach {
                val hex = it.toInt() and (0xFF)
                val hexStr = Integer.toHexString(hex)
                if (hexStr.length == 1) {
                    this.append("0").append(hexStr)
                } else {
                    this.append(hexStr)
                }
            }
            this.toString()
        }
        //转成16进制后是32字节
        return result
    }
    @Test
    fun hash() {
        val password = en("something")
        val password2 = en("something")
        println(password)

        println(password == password2)
    }
}