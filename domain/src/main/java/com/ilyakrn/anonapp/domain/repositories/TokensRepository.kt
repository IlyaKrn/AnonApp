package com.ilyakrn.anonapp.domain.repositories

interface TokensRepository {
    fun getAccessToken(): String?
    fun getRefreshToken(): String?
    fun setAccessToken(token: String)
    fun setRefreshToken(token: String)
}