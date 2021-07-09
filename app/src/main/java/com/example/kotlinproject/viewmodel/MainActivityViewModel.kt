package com.example.kotlinproject.viewmodel

import android.util.Log
import android.widget.ImageView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.kotlinproject.network.Api
import com.example.kotlinproject.model.Quiz
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivityViewModel : ViewModel() {

    var quizLiveData : MutableLiveData<Quiz> = MutableLiveData()


    fun makeApiCall(){

            val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://run.mocky.io/")
                .addConverterFactory(GsonConverterFactory.create()).build()
            val myApi = retrofit.create(Api::class.java)
            val call: Call<Quiz> = myApi.getQuiz()
            call.enqueue(object : Callback<Quiz?> {
                override fun onResponse(call: Call<Quiz?>, response: Response<Quiz?>) {
                    if (response.isSuccessful) {
                        val myQuiz: Quiz? = response.body()
                        if (myQuiz != null)
                            quizLiveData.postValue(myQuiz)
                        else
                            Log.d("failure", "myQuiz is null")
                    } else {
                        Log.d("success", "Response-->" + Gson().toJson(response))
                    }
                }

                override fun onFailure(call: Call<Quiz?>, t: Throwable) {
                    //Toast.makeText(this,"Error in getting data",Toast.LENGTH_SHORT).show()
                    Log.d("print", "Error in getting data${t.message}")
                }
            })


    }

}