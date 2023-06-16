package com.ilyakrn.anonapp.domain.models

import android.util.JsonToken

data class AuthCredentials(
    val accessToken: String,
    val refreshToken: String
)
