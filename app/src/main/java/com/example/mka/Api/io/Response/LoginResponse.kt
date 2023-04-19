package com.example.mka.Api

import com.example.mka.Api.io.Response.LoginData

data class LoginResponse(
    val success: Boolean,
    val message: String?,
    val data: LoginData?
)


