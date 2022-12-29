package com.example.radditnews2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.radditnews2.R
import com.example.radditnews2.RecyclerListFragment

class KotlinNews : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_news)
        setupFragment()
    }

    private fun setupFragment()
    {
        val fragment = RecyclerListFragment.newInstance()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(android.R.id.content,fragment)
        fragmentTransaction.commit()
    }
}