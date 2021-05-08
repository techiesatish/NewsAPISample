package com.reposenergy.data.local.db

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.reposenergy.R
import com.reposenergy.data.models.Article


@Database(entities = [Article::class], version = 1, exportSchema = false)
@TypeConverters(value = [Convertors::class])
abstract class AppDatabase : RoomDatabase() {
    abstract fun newsListDao(): ArticleDao?
}