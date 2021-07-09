package com.example.kotlinproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.kotlinproject.viewmodel.MainActivityViewModel

class FirstFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ViewAdapter
    private lateinit var img: ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        img = view.findViewById(R.id.android_Iv)
        setRecyclerView(view)
        initViewModel()
        Glide.with(view.context)
            .load("https://thumbor.forbes.com/thumbor/fit-in/1200x0/filters%3Aformat%28jpg%29/https%3A%2F%2Fspecials-images.forbesimg.com%2Fimageserve%2F1201569990%2F0x0.jpg")
            .apply(RequestOptions().fitCenter())
            .into(img)
    }

    private fun initViewModel(){
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.quizLiveData.observe(viewLifecycleOwner, {
            if(it!= null){
                adapter.setUpdatedData(it.mQuestions)
            }else{
                Toast.makeText(activity,"Error in getting data",Toast.LENGTH_SHORT).show()
            }
        })


        viewModel.makeApiCall()

    }


    private fun setRecyclerView(view: View) {
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        recyclerView.setHasFixedSize(true)
        adapter = ViewAdapter()
        recyclerView.adapter = adapter
    }

}