package com.example.kotlinproject.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class Quiz(@SerializedName("questions")var mQuestions: ArrayList<Questions>)