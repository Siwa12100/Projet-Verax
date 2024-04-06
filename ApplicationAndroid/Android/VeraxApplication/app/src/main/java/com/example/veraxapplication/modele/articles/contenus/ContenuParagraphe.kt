package com.example.veraxapplication.modele.articles.contenus

class ContenuParagraphe(id: Int, var titre: String, var texte: String) : Contenu(id) {

    init {
        this.typeContenu = "paragraphe"
    }

    val contenu: Map<String, String>
        get() {
            val contenu: MutableMap<String, String> = HashMap()
            contenu["titre"] = titre
            contenu["contenu"] = texte
            return contenu
        }

    override fun toString(): String {
        return "$texte \n\n"
    }
}
