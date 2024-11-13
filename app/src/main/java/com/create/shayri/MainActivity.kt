package com.create.shayri

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.create.shayri.routing.ShayariRouting
import com.create.shayri.ui.theme.ShayriTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {

            ShayriTheme {
                /*Create NavController Instance*/
                val navController = rememberNavController()
                ShayariRouting(navController)

            }
        }
    }
}



