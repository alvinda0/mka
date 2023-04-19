package com.example.mka.Api

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST
import retrofit2.http.Query


interface ApiService {
    @POST(value = "login")
    fun postlogin(@Query(value = "email") email: String, @Query(value = "password") password: String):
            Call<LoginResponse>


    companion object Factory{
        private const val BASE_URL = "http://127.0.0.1:8089/api/"
        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}
