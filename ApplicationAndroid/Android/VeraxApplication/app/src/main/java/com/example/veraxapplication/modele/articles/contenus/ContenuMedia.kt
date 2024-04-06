package com.example.veraxapplication.modele.articles.contenus

class ContenuMedia(id: Int, var titre: String, var lien: String) : Contenu(id) {

    init {
        this.typeContenu = "image"
    }

    val contenu: Map<String, String>
        get() {
            val contenu: MutableMap<String, String> = HashMap()
            contenu["titre"] = titre
            contenu["contenu"] = lien
            return contenu
        }

    companion object {

        fun newVideo(id: Int, titre: String, lien: String): ContenuMedia {
            val temp = ContenuMedia(id, titre, lien)

            temp.typeContenu = "video"
            return temp
        }
    }

    override fun toString(): String {
        return "$lien\n\n"
    }
}
