package com.example.veraxapplication.modele.articles

import com.example.veraxapplication.modele.articles.contenus.Contenu

class Article(
    val id: Int,
    val titre: String,
    val description: String,
    val temps: String,
    val date: String,
    val auteur: String,
    val categorie: String,
    val note: String,
    val imagePrincipale: String
) {
    public val lContenus: MutableList<Contenu> = java.util.ArrayList()

    init {
        // Initialisation des contenus si nécessaire
    }

    fun remplirArticle(lContenus: List<Contenu>?) {
        if (lContenus != null) {
            this.lContenus.addAll(lContenus)
        }
    }

    val contenus: List<Any>
        get() = lContenus

    override fun toString(): String {
        return "Article(id=$id, titre='$titre', description='$description', temps='$temps', date='$date', auteur='$auteur', imagePrincipale='$imagePrincipale', note=$note, contenus=${lContenus.size} contenus)"
    }


}
