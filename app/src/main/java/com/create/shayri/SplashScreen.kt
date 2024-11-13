package com.create.shayri

import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.create.shayri.routing.ShayariRoutingItem
import com.create.shayri.ui.theme.primaryColor
import com.create.shayri.ui.theme.primaryLight

@Composable

fun SplashScreen(navController: NavHostController) {
    Surface {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = primaryColor)
        ) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Image(
                    painterResource(id = R.drawable.logo),
                    contentDescription = "Shayari",
                    modifier = Modifier
                        .size(150.dp)
                )
            }
            Box(
                modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter
            )
            {
                CircularProgressIndicator(
                    modifier = Modifier.size(35.dp), strokeWidth = 10.dp,
                    color = primaryLight
                )
            }
        }
        /* TODO : Handler for splash screen*/
        /*Handler use for delay the screen in navigation*/
        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            navController.navigate(ShayariRoutingItem.categoryScreen.route)
        }, 3000)
    }
}