package com.example.radditnews2.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.radditnews2.model.ArticleList
import androidx.lifecycle.viewModelScope
import com.example.radditnews2.network.RetrofitBuilder
import com.example.radditnews2.network.ServiceApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class RadditNewsViewModel:ViewModel() {

     val articleMutableLiveData:MutableLiveData<ArticleList>

    init {
        articleMutableLiveData = MutableLiveData()
    }

    fun getRecyclerListObserver ():MutableLiveData<ArticleList>{
        return articleMutableLiveData
    }

    fun makeApiCall(){
        viewModelScope.launch(Dispatchers.Main){
        val retrofitBuilder =RetrofitBuilder.getRetrofitBuilder().create(ServiceApi::class.java)
        val response = retrofitBuilder.getArticles()
            articleMutableLiveData.postValue(response)
        }
    }
}