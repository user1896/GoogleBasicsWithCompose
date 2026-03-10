package com.example.googlebasicswithcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.googlebasicswithcompose.ui.theme.GoogleBasicsWithComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // All functions marked with the @Composable annotation can be called from the setContent() function
        setContent {
            GoogleBasicsWithComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Red
                ) {
                    QuadrantsScreen()
                }
            }
        }
    }

    @Composable
    fun QuadrantsScreen(modifier: Modifier = Modifier) {
        Column(modifier.fillMaxSize()) {
            QuadrantsRow(modifier = Modifier.weight(1f), col1bgr = Color.Green, col2bgr = Color.Yellow)
            QuadrantsRow(modifier = Modifier.weight(1f), col1bgr = Color.Blue, col2bgr = Color.Red)
        }
    }

    @Composable
    fun QuadrantsRow(
        modifier: Modifier = Modifier,
        col1bgr: Color = Color.Gray,
        col2bgr: Color = Color.Gray
    ) {
        Row(modifier) {
            Quadrant(modifier = Modifier.weight(1f), backgroundColor = col1bgr)
            Quadrant(modifier = Modifier.weight(1f), backgroundColor = col2bgr)
        }
    }

    @Composable
    fun Quadrant(
        modifier: Modifier = Modifier ,
        header: String = "Header",
        content: String = "Content",
        backgroundColor: Color = Color.Gray
    ) {
        Column(
            modifier
                .fillMaxSize()
                .background(backgroundColor),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = header,
                textAlign = TextAlign.Justify
            )
            Text(
                text = content,
                textAlign = TextAlign.Justify
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun BirthdayCardPreview() {
        GoogleBasicsWithComposeTheme {
            QuadrantsScreen()
        }
    }
}