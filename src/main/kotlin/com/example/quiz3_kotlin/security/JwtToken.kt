package com.example.quiz3_kotlin.security

import com.example.quiz3_kotlin.repository.TokenDAO
import com.example.quiz3_kotlin.web.model.Token
import com.example.quiz3_kotlin.web.model.Users
import io.jsonwebtoken.*
import jakarta.security.auth.message.AuthException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.io.Serializable
import java.time.Instant
import java.util.*


@Component
class JwtToken(
    @Autowired
    var tokenDAO : TokenDAO

) : Serializable{


    private val EXPIRATION_TIME = 1 * 60 * 1000 // 60000ms = 60s
    private val SECRET : String = "learn to dance in the rain"


    fun generateToken(userDetails: Users?): String {
        val claims: MutableMap<String, Any?> = HashMap()
        claims["userName"] = userDetails?.userName

        val t : String =Jwts.builder().setClaims(claims) //the payload
            .setExpiration(Date(Instant.now().toEpochMilli() + EXPIRATION_TIME)) //adding current time + 60s
            .signWith(SignatureAlgorithm.HS512, SECRET)
            .compact()

        tokenDAO.createToken(Token(
            JWTtoken = t,
            username = userDetails?.userName,
            createtime = Instant.now().toString())
        )
        return t
    }
    @Throws(AuthException::class)
    fun validateToken(token: String?) {
        println("Token get")
        try {
            if(tokenDAO.checkToken(token)){
                Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token)
            }
            else{
                throw AuthException("Please Sign in")
            }
        } catch (e: SignatureException) {
            throw AuthException("Invalid JWT signature.")
        } catch (e: MalformedJwtException) {
            throw AuthException("Invalid JWT token.")
        } catch (e: ExpiredJwtException) {
            throw AuthException("Expired JWT token")
        } catch (e: UnsupportedJwtException) {
            throw AuthException("Unsupported JWT token")
        } catch (e: IllegalArgumentException) {
            throw AuthException("JWT token compact of handler are invalid")
        }
    }


}