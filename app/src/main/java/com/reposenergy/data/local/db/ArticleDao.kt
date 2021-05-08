package com.reposenergy.data.local.db

import androidx.room.*
import com.reposenergy.data.models.Article
import com.reposenergy.data.models.ResultFlow
import kotlinx.coroutines.flow.Flow


@Dao
interface ArticleDao {

    @Query("SELECT * FROM Article")
    fun getAllNews(): List<Article>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(posts: List<Article>?)
}