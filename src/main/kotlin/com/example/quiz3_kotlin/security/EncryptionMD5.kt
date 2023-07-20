package com.example.quiz3_kotlin.security

import org.springframework.stereotype.Service
import java.security.MessageDigest

@Service
class EncryptionMD5 {
    fun hash(p:String) : String{
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
}