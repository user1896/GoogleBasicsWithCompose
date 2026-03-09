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
                    TaskCompletedScreen()
                }
            }
        }
    }

    @Composable
    fun TaskCompletedScreen(modifier: Modifier = Modifier) {
        val imagePainter = painterResource(R.drawable.ic_task_completed)
        val allTaskCompleted = stringResource(R.string.all_task_completed)
        val niceWork = stringResource(R.string.nice_work)

        Column(
            modifier
                .fillMaxSize()
                .background(Color.Blue),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = imagePainter,
                contentDescription = null
            )
            Text(
                text = allTaskCompleted,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(top = 16.dp, bottom = 4.dp)
            )
            Text(
                text = niceWork,
                textAlign = TextAlign.Justify
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun BirthdayCardPreview() {
        GoogleBasicsWithComposeTheme {
            TaskCompletedScreen()
        }
    }
}