package com.example.bisinesscard

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bisinesscard.ui.theme.BisinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BisinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeBusinessCard()
                }
            }
        }
    }
}

@Composable
fun ComposeBusinessCard(){
    BusinessCard(
        image = painterResource(R.drawable.face),
        name = "Kenji Ozawa",
        profession = "Student",
        phoneNumber = "159-3353-9274",
        mailAdress = "fkdi@kekif"
    )
}


@Composable
fun BusinessCard(
    image: Painter,
    name: String,
    profession: String,
    phoneNumber: String,
    mailAdress: String,
    modifier: Modifier = Modifier) {
    Column (

    ){

        Column {
                Column( verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally ,
                        modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .weight(8f)){
                    Image(
                        painter = image,
                        contentDescription = null
                    )
                    Text(
                        text = name,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(8.dp),
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = profession,
                        modifier = Modifier
                            .padding(8.dp),
                        textAlign = TextAlign.Center
                    )

            }
                Column (verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally ,
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .weight(1f)){
                    Text(
                        text = phoneNumber,
                        modifier = Modifier
                            .padding(8.dp),
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = mailAdress,
                        modifier = Modifier
                            .padding(8.dp),
                        textAlign = TextAlign.Center
                    )
                }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BisinessCardTheme {
        ComposeBusinessCard()
    }
}