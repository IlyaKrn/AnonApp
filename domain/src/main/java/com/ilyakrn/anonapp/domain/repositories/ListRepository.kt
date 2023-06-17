package com.ilyakrn.anonapp.domain.repositories

interface ListRepository {
    fun getRecommendations(token: String, offset: Int, count: Int): ArrayList<Long>
}