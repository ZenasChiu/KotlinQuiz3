package com.example.quiz3_kotlin.security

import com.example.quiz3_kotlin.web.model.Users
import io.jsonwebtoken.*
import jakarta.security.auth.message.AuthException
import org.springframework.stereotype.Component
import java.io.Serializable
import java.time.Instant
import java.util.*


@Component
class JwtToken : Serializable {
    private val EXPIRATION_TIME = 1 * 60 * 1000
    private val SECRET : String = "learn to dance in the rain"

    fun generateToken(userDetails: Users): String? {
        val claims: MutableMap<String, Any?> = HashMap()
        claims["userName"] = userDetails?.userName
        return Jwts.builder()
            .setClaims(claims)
            .setExpiration(Date(Instant.now().toEpochMilli() + EXPIRATION_TIME))
            .signWith(SignatureAlgorithm.HS512, SECRET)
            .compact()
    }
    @Throws(AuthException::class)
    fun validateToken(token: String?) {
        try {
            Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
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