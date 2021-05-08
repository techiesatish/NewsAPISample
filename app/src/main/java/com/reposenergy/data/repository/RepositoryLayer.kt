package com.reposenergy.data.repository

import android.content.Context
import com.reposenergy.common.AppUtils
import com.reposenergy.data.local.db.AppDatabase
import com.reposenergy.data.models.Article
import com.reposenergy.data.models.News
import com.reposenergy.data.models.ResultFlow
import com.reposenergy.data.remote.RemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception
import javax.inject.Inject

class RepositoryLayer  @Inject constructor(
    private val remoteDataSource: RemoteDataSource
    ,private val db: AppDatabase
    ,private val mContext: Context) {


    suspend fun fetchNews(country:String,apiKey: String): Flow<List<Article>?> {

        return flow {
            try {
                if(AppUtils.isNetworkConnected(mContext)){
                    val response=remoteDataSource.fetchNews(country,apiKey).data!!.articles
                    emit(response)
                    db.newsListDao()!!.insertAll(response)
                }else{
                    emit(db.newsListDao()!!.getAllNews())
                }

                } catch (e: Exception){
                e.printStackTrace()
            }


        }.flowOn(Dispatchers.IO)
    }
}