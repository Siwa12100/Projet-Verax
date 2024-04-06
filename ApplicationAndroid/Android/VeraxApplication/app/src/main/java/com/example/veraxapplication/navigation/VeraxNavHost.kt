package com.example.veraxapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.veraxapplication.MainActivity
import com.example.veraxapplication.modele.articles.Article
import com.example.veraxapplication.ui.article.AffichageLesArticles
import com.example.veraxapplication.ui.article.AfficherArticle

@Composable
fun VeraxNavHost(articles : List<Article>, navController: NavHostController) {


    NavHost(
        navController = navController,
        startDestination = "accueil"
    ){
        composable(route="accueil"){
            AffichageLesArticles(
                articles = articles,
                goToArticle = {
                    navController.navigate("article/${it.id}")
                }
            )
        }

        composable(
            route="article/{articleid}",
            arguments= listOf(navArgument("articleid"){ type= NavType.IntType})
        ){
            it.arguments?.getInt("articleid")?.let { articleid ->
                articles.find { it.id == articleid }?.let {
                    AfficherArticle(
                        e = it
                    )
                }
            }
        }
    }


}