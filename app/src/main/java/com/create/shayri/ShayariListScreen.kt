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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.create.shayri.routing.ShayariRoutingItem
import com.create.shayri.ui.theme.primaryColor
import com.create.shayri.ui.theme.primaryLight


@Composable
@Preview(showBackground = true, showSystemUi = true)

fun DemoPreview(modifier: Modifier = Modifier) {
    ShayariListScreen(title = "Love")
}

@Composable

fun ShayariListScreen(navController: NavHostController? = null, title: String? = null) {
    Surface {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = primaryColor)
        ) {
            Column {
                MainToolBar(title = title.toString()) {
                    navController?.popBackStack()
                }
                /*Create Filter List For Showing Shayari "it.title" use for filter the list*/
                val myFinaList = getListOfCategory().filter { it.title == title.toString() }
                /*This val use for get the first list Size*/
                val finalList = myFinaList[0]

                finalList.list?.let { list ->
                    LazyColumn() {
                        items(list) { item ->

                            Card(
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(100.dp)
                                    .padding(20.dp)
                                    .clickable {
                                        /*Null Check Use For Handling Null*/
                                        navController?.navigate(
                                            ShayariRoutingItem.finalShayariViewScreen.route + "/${item}"
                                        )
                                    },

                                colors = CardDefaults.cardColors(containerColor = primaryLight)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(10.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        item.toString(),
                                        overflow = TextOverflow.Ellipsis,
                                        textAlign = TextAlign.Center,
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

}