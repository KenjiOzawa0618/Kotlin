package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Button
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.lemonade.R
import com.example.lemonade.ui.theme.LemonadeTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonadeApp()

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    LemonadeWithButtonAndImage()
}
@Composable
fun LemonadeWithButtonAndImage(modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)){
    var count by remember { mutableStateOf(1) }
    var squeeze by remember { mutableStateOf(1) }
    when (count) {
        1 -> {
            Column( modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally){
                Image(
                    painter = painterResource(id = R.drawable.lemon_tree),
                    contentDescription = null,
                    modifier = Modifier
                            .clickable {count++
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(stringResource(R.string.LemonTree))
            }
        }
        2 -> {
            Column( modifier = modifier,
                horizontalAlignment = Alignment.CenterHorizontally){
                Image(
                    painter = painterResource(id = R.drawable.lemon_squeeze),
                    contentDescription = null,
                    modifier = Modifier
                        .clickable {
                            count++
                            squeeze = Random.nextInt(1, 4)
                        }
                )

                Spacer(modifier = Modifier.height(16.dp))
                Text(stringResource(R.string.Lemon))
            }
        }

        3 -> {
            Column( modifier = modifier,
                horizontalAlignment = Alignment.CenterHorizontally){
                Image(
                    painter = painterResource(id = R.drawable.lemon_squeeze),
                    contentDescription = null,
                    modifier = Modifier
                        .clickable {
                            squeeze--
                            if(squeeze == 0){
                                count = 4
                            }
                        }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(stringResource(R.string.Lemon))
            }
        }

        4 -> {
            Column( modifier = modifier,
                horizontalAlignment = Alignment.CenterHorizontally){
                Image(
                    painter = painterResource(id = R.drawable.lemon_drink),
                    contentDescription = null,
                    modifier = Modifier
                        .clickable {
                            count = 5
                        }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(stringResource(R.string.GlassOfLemonade))
            }
        }



        else -> {
            Column( modifier = modifier,
                horizontalAlignment = Alignment.CenterHorizontally){
                Image(
                    painter = painterResource(id = R.drawable.lemon_restart),
                    contentDescription = null,
                    modifier = Modifier
                        .clickable {
                            count = 1
                        }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(stringResource(R.string.EmptyGlass))
            }
        }
    }
}
