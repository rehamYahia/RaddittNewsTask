package com.example.radditnews2.network


import com.example.radditnews2.model.ArticleList
import retrofit2.http.GET

interface ServiceApi {

@GET("r/kotlin/.json")
suspend fun getArticles(): ArticleList

}