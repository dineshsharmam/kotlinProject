package com.example.kotlinproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()

        //fragment

        //fragment
        val firstFragment = FirstFragment()
        transaction.add(R.id.pageContainer, firstFragment)

        transaction.commit()
    }
}