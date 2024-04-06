package com.example.veraxapplication.articles

import com.example.veraxapplication.modele.articles.Article


interface IArticlesDataManager {
    val allArticles: List<Any?>?

    fun getArticle(id: Int): Article?
    fun getDerniersArticles(nbArticles: Int): List<Article>
}