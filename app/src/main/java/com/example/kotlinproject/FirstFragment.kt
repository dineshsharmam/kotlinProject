package com.example.kotlinproject

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FirstFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ViewAdapter
    private lateinit var img: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)
        img = view.findViewById(R.id.android_Iv)
        recyclerView.setLayoutManager(
            LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        )
        recyclerView.setHasFixedSize(true)
        initJson()
        Glide.with(requireContext())
            .load("https://thumbor.forbes.com/thumbor/fit-in/1200x0/filters%3Aformat%28jpg%29/https%3A%2F%2Fspecials-images.forbesimg.com%2Fimageserve%2F1201569990%2F0x0.jpg")
            .apply(RequestOptions().fitCenter())
            .into(img)
    }

    private fun initJson() {
        val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://run.mocky.io/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val myApi = retrofit.create(Api::class.java)
        val call: Call<Quiz> = myApi.getQuiz()
        call.enqueue(object : Callback<Quiz?> {
            override fun onResponse(call: Call<Quiz?>, response: Response<Quiz?>) {
                if (response.isSuccessful()) {
                    val myquiz: Quiz? = response.body()
                    if (myquiz != null)
                        setRecyclerView(myquiz)
                    else
                        Log.d("failure", "myquiz is null")
                } else {
                    Log.d("success", "Response-->" + Gson().toJson(response))
                }
            }

            override fun onFailure(call: Call<Quiz?>, t: Throwable) {
                Toast.makeText(
                    activity!!.applicationContext,
                    "An error has occured",
                    Toast.LENGTH_LONG
                ).show()
                Log.d("print", t.message!!)
            }
        })
    }

    private fun setRecyclerView(myquiz: Quiz) {
        adapter = ViewAdapter(requireActivity().applicationContext, myquiz)
        recyclerView.adapter = adapter
    }

}