package com.create.shayri

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.create.shayri.routing.ShayariRoutingItem
import com.create.shayri.ui.theme.primaryColor
import com.create.shayri.ui.theme.primaryLight


@Composable

fun CategoryScreen(navController: NavHostController) {
    Surface {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = primaryColor)
        ) {
            Column() {
                MainToolBar("Category") { //:TODO: onClick
                }

                LazyColumn() {
                    items(getListOfCategory()) { item ->
                        Card(
                            shape = RoundedCornerShape(20.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .padding(10.dp)
                                .clickable {
                                    navController.navigate(ShayariRoutingItem.shayariListScreen.route + "/${item.title.toString()}")
                                },
                            colors = CardDefaults.cardColors(containerColor = primaryLight)
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    item.title.toString(),

                                    style = TextStyle(
                                        color = Color.White, fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold,
                                    )
                                )
                            }
                        }
                    }

                }

            }
        }

    }
}