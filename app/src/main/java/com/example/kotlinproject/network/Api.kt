package com.example.kotlinproject.network

import com.example.kotlinproject.model.Quiz
import retrofit2.Call
import retrofit2.http.GET

interface Api {


    @GET("v3/3a016adf-9dd5-4190-8569-d419d5e5a660")
    fun getQuiz(): Call<Quiz>

}