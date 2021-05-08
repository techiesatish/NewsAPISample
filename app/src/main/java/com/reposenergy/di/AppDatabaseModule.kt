package com.reposenergy.di

import android.app.Application
import androidx.room.Room
import com.reposenergy.data.local.db.AppDatabase
import com.reposenergy.data.local.db.ArticleDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppDatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): AppDatabase {
        return Room
            .databaseBuilder(app, AppDatabase::class.java, "newsster_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideArticleDao(appDb: AppDatabase): ArticleDao {
        return appDb.newsListDao()!!
    }

}