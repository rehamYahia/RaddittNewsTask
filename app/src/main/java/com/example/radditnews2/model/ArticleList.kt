package com.example.radditnews2.model

data class ArticleList (val children:ArrayList<Children>)
data class Children(val `data`: DataX)
data class DataX(val title:String , val selftext:String ,  val media:Media)
data class Media(val oembed: Oembed)
data class Oembed(val thumbnail_url: String)
