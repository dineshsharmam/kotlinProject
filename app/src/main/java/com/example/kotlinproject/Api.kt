package com.example.kotlinproject

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {


    @GET("v3/3a016adf-9dd5-4190-8569-d419d5e5a660")
    fun getQuiz(): Call<Quiz>


//    var BASE_URL: String
//        get() = "https://run.mocky.io/"
//        set(value) =
//
//    @GET("v3/3a016adf-9dd5-4190-8569-d419d5e5a660")
//    fun getquiz(): Call<Quiz?>?
}