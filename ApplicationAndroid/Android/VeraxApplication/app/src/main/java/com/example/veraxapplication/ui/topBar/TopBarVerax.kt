package com.example.veraxapplication.ui.topBar

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.veraxapplication.R
import com.example.veraxapplication.modele.articles.Article
import com.example.veraxapplication.navigation.VeraxNavHost
import com.example.veraxapplication.ui.theme.Orange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarVerax(theme: List<String>, articles: List<Article>) {
    var leMenu by remember {
        mutableStateOf(false)
    }

    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()

    Row( modifier = Modifier.background(Color.Blue).fillMaxSize()) {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = "Verax",
                            style = TextStyle(fontSize = 35.sp),
                            color = colorResource(R.color.red),
                            textAlign = TextAlign.Center,
                            /*backcolor = topAppBarColors(
                                    containerColor = MaterialTheme.colorScheme.primaryContainer),*/ //version recommandée par le prof
                            modifier = Modifier.fillMaxWidth()
                        )
                    },
                    navigationIcon = { if (navBackStackEntry?.destination?.route != "accueil"){
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Retour",
                                Modifier.size(30.dp)
                            )
                        }
                    }

                    },
                    actions = {
                        IconButton(onClick = { leMenu = !leMenu }) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = "Menu",
                                Modifier.size(35.dp)
                            )
                        }
                        DropdownMenu(
                            expanded = leMenu, onDismissRequest = { leMenu = false },
                            modifier = Modifier
                                .border(
                                    width = 1.dp,
                                    color = Color.Black,
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .background(Orange)
                        ) {
                            theme.sorted().forEach {
                                DropdownMenuItem(
                                    text = {
                                        Text(
                                            it,
                                            style = TextStyle(fontSize = 25.sp),
                                            modifier = Modifier
                                                .padding(10.dp)
                                        )
                                    },
                                    onClick = { /* faut un moyen d'appeler une methode diff pour chaque, ca doit etre faisable facilement */ }
                                )
                            }
                        }
                    }

                )
            }/*,
            bottomBar = {
                // Faudrait pouvoir faire un flex sur les boutons parce que là ils sont juste côte à côte
                BottomAppBar(containerColor = Color.Black, contentColor = Color.White) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.Home,
                            contentDescription = "Home",
                            Modifier.size(35.dp)
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = "Account",
                            Modifier.size(35.dp)
                        )
                    }
                }
            }*/
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {

                // AffichageLesArticles(articles = articles)
                // AfficherArticle(articles.get(0))

                VeraxNavHost(articles = articles, navController)


            }
        }
    }
}