package com.example.kotlinproject

import com.google.gson.annotations.SerializedName
import java.util.*

data class Questions(@SerializedName("question")var mQuestion: String? = null,@SerializedName("options")var mOptions: ArrayList<String>,@SerializedName("answer")var mAnswer: String? = null) {

}