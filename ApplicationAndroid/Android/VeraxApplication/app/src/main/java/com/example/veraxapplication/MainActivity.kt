package com.example.veraxapplication

import ArticlesViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.veraxapplication.articles.IArticlesDataManager
import com.example.veraxapplication.articles.StubArticles
import com.example.veraxapplication.ui.topBar.TopBarVerax


// doc navBar: https://developer.android.com/reference/kotlin/androidx/compose/material3/package-summary#TopAppBar(kotlin.Function0,androidx.compose.ui.Modifier,kotlin.Function0,kotlin.Function1,androidx.compose.foundation.layout.WindowInsets,androidx.compose.material3.TopAppBarColors,androidx.compose.material3.TopAppBarScrollBehavior)
// doc compose, pleins de trucs: https://developer.android.com/jetpack/compose/text?hl=fr
//doc couleur background pas finie: https://developer.android.com/jetpack/compose/components/scaffold

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VeraxContent()
        }
    }
}

@Composable
fun VeraxContent() {


    // Initialiser les données ou observer les données du ViewModel
    var dataManager: IArticlesDataManager = StubArticles()
    var articles = dataManager.getDerniersArticles(4)

    // Observer les données du ViewModel
    val articlesViewModel: ArticlesViewModel = viewModel()

    // Observez les articles du ViewModel
    val articlesApi by articlesViewModel.articles.observeAsState(initial = articles)


    var theme = listOf("Economique", "Culture", "Politique", "Faits divers")

    TopBarVerax(articles = articlesApi, theme = theme)

    // VeraxNavHost()

}