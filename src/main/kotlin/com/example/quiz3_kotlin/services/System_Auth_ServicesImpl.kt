package com.example.quiz3_kotlin.services

import com.example.quiz3_kotlin.repository.TokenDAO
import com.example.quiz3_kotlin.repository.UserRepository
import com.example.quiz3_kotlin.security.EncryptionMD5
import com.example.quiz3_kotlin.security.JwtToken
import com.example.quiz3_kotlin.web.model.UserDTO
import com.example.quiz3_kotlin.web.model.Users
import jakarta.security.auth.message.AuthException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.sql.SQLException

@Service
class System_Auth_ServicesImpl(
    @Autowired
    var md5 : EncryptionMD5,

    @Autowired
    var jwtToken: JwtToken,

    @Autowired
    var userRepository: UserRepository,

    @Autowired
    var tokenDAO : TokenDAO

) : System_Auth_Services {

    override fun userSignUp(userDTO: UserDTO): Boolean {
        try{
        userRepository.createUser(Users(
            userName = userDTO.userName,
            password = md5.hash(userDTO.password.toString()),
            email = userDTO.email
            ))
            return true
        }
        catch (e : SQLException){
            return false
        }

    }

    override fun userSignIn(userDTO: UserDTO): String {
        val check_user : Users?= userRepository.getUserByName(userDTO.userName.toString())
        when(check_user?.password == md5.hash(userDTO.password.toString())){
            true -> {
                val t: String = jwtToken.generateToken(check_user)

                return t
            }
            false -> return "Wrong User or password"
            else -> return "Enter format wrong"
        }


        TODO("encrypt the ender password MD5 one way encrypt & compare with data from database")
        //return false
    }

    override fun userSignout(token: String) {
        try{
        tokenDAO.removeToken(token)
        }
        catch (e : AuthException){
            throw e
        }
    }
}