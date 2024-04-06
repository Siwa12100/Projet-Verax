package com.example.veraxapplication.ui.article

import VideoPlayer
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.veraxapplication.modele.articles.Article
import com.example.veraxapplication.modele.articles.contenus.ContenuMedia
import com.example.veraxapplication.modele.articles.contenus.ContenuParagraphe
import com.example.veraxapplication.ui.theme.Salmon

@Composable
fun AffichageLesArticles(articles : List<Article>, goToArticle: (Article) -> Unit){
    Column(modifier = Modifier.verticalScroll(rememberScrollState())){
        for(article in articles){
            Box {
                AffichageUnArticleInfo(e = article, goToArticle)
            }
        }
    }
}

@Composable
fun AffichageUnArticleInfo(e : Article, goToArticle: (Article) -> Unit){
    Column(modifier = Modifier
        .padding(7.dp)
        .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(10.dp))
        .padding(5.dp)) {

        Text(text = e.titre, fontFamily = FontFamily.Serif, fontSize = 30.sp)

        Box(modifier = Modifier
            .padding(15.dp)
            .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp))
            .background(Salmon)
        ) {
            Column (modifier = Modifier.padding(15.dp)) {
                Text(text = "Auteur : "+e.auteur, fontSize = 17.sp)
                Text(text = "Description : "+e.description, fontSize = 17.sp)
                Text(text = "Temps de lecture : "+e.temps+" minutes", fontSize = 17.sp)
            }
        }
        Log.d("ImageLoad", e.toString())
        Image(
            painter = rememberImagePainter(
                data = e.imagePrincipale
            ),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier
                .size(350.dp)
                .align(Alignment.CenterHorizontally)
                .padding(5.dp, 35.dp)
        )


        Button(onClick = { goToArticle(e)},
            colors = ButtonDefaults.buttonColors(
                containerColor = Salmon,
                contentColor = Color.Black
            ),
            border = BorderStroke(1.dp, Color.Black),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Voir plus")
        }

    }
}



@Composable
fun AfficherArticle(e : Article) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(7.dp)
            .padding(5.dp)
    ) {

        Text(text = e.titre, fontFamily = FontFamily.Serif, fontSize = 30.sp)

        Box(
            modifier = Modifier
                .padding(15.dp)
                .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(10.dp))
                .clip(RoundedCornerShape(10.dp))
                .background(Salmon)
        ) {
            Column(modifier = Modifier.padding(15.dp)) {
                Text(text = "Auteur : " + e.auteur, fontSize = 17.sp)
                Text(text = "Description : " + e.description, fontSize = 17.sp)
                Text(text = "Temps de lecture : " + e.temps + " minutes", fontSize = 17.sp)
            }
        }
        Image(
            painter = rememberImagePainter(
                data = e.imagePrincipale
            ),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier
                .size(350.dp)
                .align(Alignment.CenterHorizontally)
                .padding(5.dp, 35.dp)
        )



        Column(modifier = Modifier) {
            for (text in e.contenus) {
                when (text) {
                    is ContenuMedia -> {
                        Text(text = text.titre, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        when (text.typeContenu) {
                            "image" -> {
                                Image(
                                    painter = rememberImagePainter(
                                        data = text.lien
                                    ),
                                    contentScale = ContentScale.FillHeight,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(350.dp)
                                        .align(Alignment.CenterHorizontally)
                                        .padding(5.dp, 35.dp)
                                )
                            }

                            "video" -> {
                                Text(
                                    text = "Ici une video ..." + text.toString(),
                                    fontSize = 15.sp,
                                    textAlign = TextAlign.Start
                                )
                                // le player video marche a moitié mais honnetenement je comprends pas le soucis
                                VideoPlayer(videoUrl = text.lien)
                            }
                        }


                    }

                    is ContenuParagraphe -> {
                        Text(text = text.titre, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        Text(text = text.toString(), fontSize = 16.sp, textAlign = TextAlign.Start)
                    }
                }
            }
        }
    }
}


@Composable
fun DisplayHeader(author: String, description: String, lectureTime: String) {
    Box(
        modifier = Modifier
            .padding(15.dp)
            .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp))
            .background(Salmon)
    ) {
        Column(modifier = Modifier.padding(15.dp)) {
            Text(text = "Auteur : "+ author, fontSize = 17.sp)
            Text(text = "Description : "+ description, fontSize = 17.sp)
            Text(text = "Temps de lecture : " + lectureTime + " minutes", fontSize = 17.sp)
        }
    }
}
@Composable
fun DisplayImage(imageURl : String){
    Log.d("ImageLoad", "URL de l'image reçue de l'API : $imageURl")

    Image(
        painter = rememberImagePainter(
            data = imageURl
        ),
        contentScale = ContentScale.Crop,
        contentDescription = null,
        modifier = Modifier
            .size(350.dp)
            .padding(5.dp, 35.dp)
    )
}