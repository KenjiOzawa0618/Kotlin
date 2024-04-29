package com.example.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composequadrant.R
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeQuadrantExpress()
                }
            }
        }
    }

    @Composable
    fun ComposeQuadrantExpress() {
        QuadrantExpress(
            title_1 = stringResource(R.string.text_composable),
            title_2 = stringResource(R.string.image_composable),
            title_3 = stringResource(R.string.row_composable),
            title_4 = stringResource(R.string.column_composable),
            text_1 = stringResource(R.string.displays_text_and_follows_the_recommended_material_design_guidelines),
            text_2 = stringResource(R.string.creates_a_composable_that_lays_out_and_draws_a_given_painter_class_object),
            text_3 = stringResource(R.string.a_layout_composable_that_places_its_children_in_a_horizontal_sequence),
            text_4 = stringResource(R.string.a_layout_composable_that_places_its_children_in_a_vertical_sequence)
        )
    }

    @Composable
    private fun QuadrantExpress(
        text_1: String,
        text_2: String,
        text_3: String,
        text_4: String,
        title_1: String,
        title_2: String,
        title_3: String,
        title_4: String,
        modifier: Modifier = Modifier
    )
    {
        Column(){
            Row (modifier = Modifier.weight(1f)){
                Box(modifier = Modifier
                    .weight(1f)
                    .background(Color(0xFFEADDFF)),
                    )
                {
                    Column(modifier = Modifier
                        .padding(16.dp)
                        .fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center)
                    {
                        Text(
                            text = title_1,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(bottom = 16.dp),
                        )
                        Text(
                            text = text_1,
                            modifier = Modifier
                                .background(Color(0xFFEADDFF)),
                            textAlign = TextAlign.Justify
                        )
                    }
                }
                Box(modifier = Modifier
                    .weight(1f)
                    .background(Color(0xFFD0BCFF))) {
                    Column (modifier = Modifier
                        .padding(16.dp)
                        .fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center)
                    {
                        Text(
                            text = title_2,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(bottom = 16.dp)
                                .background(Color(0xFFD0BCFF)),
                        )
                        Text(
                            text = text_2,
                            modifier = Modifier,
                            textAlign = TextAlign.Justify
                        )
                    }
                }
            }
            Row (modifier = Modifier.weight(1f)){
                Box(modifier = Modifier
                    .weight(1f)
                    .background(Color(0xFFB69DF8))) {
                    Column (modifier = Modifier
                        .padding(16.dp)
                        .fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center)
                    {
                        Text(
                            text = title_3,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(bottom = 16.dp)
                                .background(Color(0xFFB69DF8))
                        )
                        Text(
                            text = text_3,
                            modifier = Modifier,
                            textAlign = TextAlign.Justify
                        )
                    }
                }
                Box (modifier = Modifier
                    .weight(1f)
                    .background(Color(0xFFF6EDFF))){
                    Column (modifier = Modifier
                        .padding(16.dp)
                        .fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center){
                        Text(
                            text = title_4,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(bottom = 16.dp)
                        )
                        Text(
                            text = text_4,
                            modifier = Modifier
                                .background(Color(0xFFF6EDFF)),
                            textAlign = TextAlign.Justify
                        )
                    }
                }

            }

        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        ComposeQuadrantTheme {
            ComposeQuadrantExpress()
        }
    }
}