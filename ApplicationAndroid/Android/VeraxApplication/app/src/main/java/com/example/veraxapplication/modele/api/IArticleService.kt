package com.example.veraxapplication.modele.api

import retrofit2.http.GET

interface IArticleService {
    @GET("articles")
    suspend fun getArticles(): List<ArticleDTO>
}