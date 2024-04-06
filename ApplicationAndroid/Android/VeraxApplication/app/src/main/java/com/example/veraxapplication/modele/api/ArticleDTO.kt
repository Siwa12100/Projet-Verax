package com.example.veraxapplication.modele.api

import com.example.veraxapplication.modele.articles.Article
import com.google.gson.annotations.SerializedName

data class ArticleDTO (

    @SerializedName("id")
    val id: Int,
    @SerializedName("titre")
    val titre: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("temps")
    val temps: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("auteur")
    val auteur: String,
    @SerializedName("categorie")
    val categorie: String,
    @SerializedName("imagePrincipale")
    val imagePrincipale: String,
    @SerializedName("note")
    val note: String,

    ) {
    fun toModel(): Article {
        return Article(
            id,
            titre,
            description,
            temps,
            date,
            auteur,
            categorie,
            imagePrincipale,
            note,
            )
    }
}



data class ContenuDTO (
    @SerializedName("id")
    val id: Int,
    @SerializedName("typeContenu")
    val typeContenu: String,
    @SerializedName("titre")
    val titre: String,
    @SerializedName("texte")
    val texte: String,
)