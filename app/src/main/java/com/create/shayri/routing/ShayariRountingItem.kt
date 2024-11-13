package com.create.shayri.routing

sealed class ShayariRoutingItem(val route: String) {

    object splashScreen : ShayariRoutingItem("splash")
    object categoryScreen : ShayariRoutingItem("category")
    object shayariListScreen : ShayariRoutingItem("shayariListScreen")
    object finalShayariViewScreen : ShayariRoutingItem("finalShayariViewScreen")
}