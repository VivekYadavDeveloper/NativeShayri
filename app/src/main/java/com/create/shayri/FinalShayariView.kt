import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavHostController
import com.create.shayri.MainToolBar
import com.create.shayri.R
import com.create.shayri.ui.theme.primaryColor
import com.create.shayri.ui.theme.primaryLight

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun DemoPreview(modifier: Modifier = Modifier) {
    FinalShayariViewScreen()
}

@Composable
fun FinalShayariViewScreen(
    navController: NavHostController? = null,
    finalShayari: String? = null,
) {
    Surface {

        val content = LocalContext.current
        val clipboardManager: ClipboardManager = LocalClipboardManager.current
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = primaryColor)
        ) {
            Column {
                MainToolBar(title = "") {
                    navController?.popBackStack()
                }

                Card(
                    shape = RoundedCornerShape(10.dp),
                    colors = CardDefaults.cardColors(containerColor = primaryLight),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(299.dp)
                        .padding(20.dp)
                        .border(2.dp, Color.Gray, RoundedCornerShape(10.dp)) // Border with color and shape
                        .clickable {
                            navController?.popBackStack()
                        }
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text(
                            text = finalShayari.toString(),
                            color = Color.White, // Text color set to white

                        )
                    }
                }


                Box(
                    modifier = Modifier
                        .fillMaxWidth()

                        .padding(20.dp)

                ) {
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround,
                    ) {
                        Card(
                            shape = RoundedCornerShape(100.dp),
                            modifier = Modifier
                                .size(46.dp, 36.dp)
                                .clickable {

                                    val SharingIntent = Intent().apply {
                                        action = Intent.ACTION_SEND
                                        putExtra(Intent.EXTRA_TEXT, finalShayari.toString())
                                        type = "text/plain"

                                    }
                                    startActivity(content, SharingIntent, null)

                                    /*TODO : Share Shayari*/
                                },
                            colors = CardDefaults.cardColors(containerColor = primaryLight)
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    painterResource(R.drawable.share),
                                    contentDescription = null,
                                    tint = Color.White
                                )
                            }
                        }
                        Card(
                            shape = RoundedCornerShape(100.dp),
                            modifier = Modifier
                                .size(46.dp, 36.dp)
                                .clickable {
                                    clipboardManager.setText(
                                        androidx.compose.ui.text.AnnotatedString(
                                            finalShayari.toString()
                                        )

                                    )
                                    Toast
                                        .makeText(content, "Copied", Toast.LENGTH_SHORT)
                                        .show()/*TODO: Copy Shayari*/
                                },
                            colors = CardDefaults.cardColors(containerColor = primaryLight)
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(

                                    painterResource(R.drawable.ic_copy),
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(25.dp)
                                )
                            }
                        }
                    }
                }
            }

        }
    }
}