package com.ilyakrn.anonapp.domain.repositories

import com.ilyakrn.anonapp.domain.models.AuthCredentials

interface AuthRepository {

    fun login(login: String, password: String): AuthCredentials?
    fun refresh(refreshToken: String): AuthCredentials?
    fun register(login: String, password: String): AuthCredentials?

}