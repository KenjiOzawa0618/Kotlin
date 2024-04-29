package com.example.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeCompleteExpress()
                }
            }
        }
    }

    @Composable
    fun ComposeCompleteExpress() {
        CompleteExpress(
            image = painterResource(R.drawable.ic_task_completed),
            text_1 = stringResource(R.string.all_tasks_completed),
            text_2 = stringResource(R.string.nice_work)
        )
    }

    @Composable
    private fun CompleteExpress(
        image: Painter,
        text_1: String,
        text_2: String,
        modifier: Modifier = Modifier
    )
    {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ){
            Image(
                painter = image,
                contentDescription = null
            )
            Text(
                text = text_1,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 24.dp, bottom = 8.dp),
                textAlign = TextAlign.Center
            )

            Text(
                text = text_2,
                fontSize = 16.sp,
            )

        }

    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        TaskManagerTheme {
            ComposeCompleteExpress()
        }
    }
}