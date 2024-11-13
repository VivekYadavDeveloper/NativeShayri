package com.create.shayri.routing

import FinalShayariViewScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.create.shayri.CategoryScreen
import com.create.shayri.ShayariListScreen
import com.create.shayri.SplashScreen


@Composable

        /*This function use for handling routing b/w the screen*/
fun ShayariRouting(navController: NavHostController ) {
    NavHost(
        navController = navController,
        startDestination = ShayariRoutingItem.splashScreen.route
    ) {
        /*composable use for routing*/
        /*Use For Category Screen Routing*/
        composable(ShayariRoutingItem.categoryScreen.route) {
            CategoryScreen(navController)
        }
        /*Use For Splash Screen Routing*/
        composable(ShayariRoutingItem.splashScreen.route) {
            SplashScreen(navController)
        }

        /*Use For Shayari List Screen Routing*/
        composable(ShayariRoutingItem.shayariListScreen.route + "/{title}") {
            val title = it.arguments?.getString("title")
            ShayariListScreen(navController, title.toString())
        }
        composable(ShayariRoutingItem.finalShayariViewScreen.route + "/{item}") {
            val item = it.arguments?.getString("item").toString()
            FinalShayariViewScreen(navController,item)
        }

    }
}