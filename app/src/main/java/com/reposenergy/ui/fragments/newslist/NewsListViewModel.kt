package com.reposenergy.ui.fragments.newslist

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reposenergy.BuildConfig
import com.reposenergy.data.models.Article
import com.reposenergy.data.models.ResultFlow
import com.reposenergy.data.repository.RepositoryLayer
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList

class NewsListViewModel  @ViewModelInject constructor(val mainRepository: RepositoryLayer): ViewModel() {


    var articleList= MutableLiveData<ArrayList<Article>>()

    fun fetchNews(){
        viewModelScope.launch {
            mainRepository.fetchNews("us", BuildConfig.API_KEY).collect {
                articleList.postValue(it!! as ArrayList<Article>?)
            }
        }
    }
    }

