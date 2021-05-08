package com.reposenergy.data.models

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.io.Serializable


data class News(
	@field:SerializedName( "articles")
	var articles: List<Article>?,
	@field:SerializedName( "status")
	var status: String?,
	@field:SerializedName( "totalResults")
	var totalResults: Int?
)

@Entity
data class Article(
	@field:SerializedName( "author")
	var author: String?,
	@field:SerializedName( "content")
	var content: String?,
	@field:SerializedName( "description")
	var description: String?,
	@field:SerializedName( "publishedAt")
	var publishedAt: String?,
	@field:SerializedName( "source")
	var source: Source?,
	@field:SerializedName( "title")
	var title: String?,
	@NonNull
	@PrimaryKey
	@field:SerializedName( "url")
	var url: String,
	@field:SerializedName( "urlToImage")
	var urlToImage: String?
):Serializable

data class Source(
	@field:SerializedName( "id")
	var id: Any?,
	@field:SerializedName( "name")
	var name: String?
)

