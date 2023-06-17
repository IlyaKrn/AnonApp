package com.ilyakrn.anonapp.domain.repositories

import com.ilyakrn.anonapp.domain.models.PostModel

interface PostRepository {
    fun getById(token: String, id: Long): PostModel?
    fun like(token: String, id: Long): Boolean
    fun unlike(token: String, id: Long): Boolean
    fun ban(token: String, id: Long): Boolean
    fun unban(token: String, id: Long): Boolean
    fun report(token: String, id: Long, text: String): Boolean
}