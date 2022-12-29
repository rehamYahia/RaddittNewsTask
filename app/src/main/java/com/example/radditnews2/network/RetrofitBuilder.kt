package com.example.radditnews2.network


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {
    companion object{
        val BASE_URL: String = "https://www.reddit.com/";
        fun getRetrofitBuilder():Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        }
    }
}