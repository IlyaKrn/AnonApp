package com.ilyakrn.anonapp.domain.usecases

import com.ilyakrn.anonapp.domain.repositories.AuthRepository
import com.ilyakrn.anonapp.domain.repositories.TokensRepository

class RegisterUseCase(private val login: String, private val password: String, private val authRepository: AuthRepository, private val tokensRepository: TokensRepository) {

    fun invoke(): Boolean{
        val credentials = authRepository.register(login, password)
        credentials?.let {
            tokensRepository.setAccessToken(it.accessToken)
            tokensRepository.setRefreshToken(it.refreshToken)
            return true
        }
        return false
    }



}