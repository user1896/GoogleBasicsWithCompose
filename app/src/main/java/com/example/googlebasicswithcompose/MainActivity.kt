package com.example.googlebasicswithcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.googlebasicswithcompose.ui.theme.GoogleBasicsWithComposeTheme

class MainActivity : ComponentActivity() {
    //  onCreate() function is the entry point.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // All functions marked with the @Composable annotation can be called from the setContent() function
        setContent {
            GoogleBasicsWithComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(
                        modifier = Modifier.padding(4.dp),
                        message = "Happy Android",
                        from = "Developer"
                    )
                }
            }
        }
    }

    @Composable
    fun GreetingText(modifier: Modifier = Modifier, message: String = "Hello", from: String = "Sender") {
        Column( // instead of arranging our components as a Column, we also could use Row or Box.
            modifier,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "$message!",
                fontSize = 100.sp, // "sp" resizes based on the user's preferred text size under phone settings.
                lineHeight = 116.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = from,
                fontSize = 26.sp,
                modifier = Modifier
                    .padding(16.dp)
                    .align(alignment = Alignment.End) // also can do: .align(Alignment.End)
            )
        }
    }

    @Composable
    fun GreetingImage(modifier: Modifier = Modifier, message: String, from: String) {
        val image = painterResource(R.drawable.androidparty)
        Box(modifier) {
            Image(
                painter = image,
                contentDescription = null
            )
            GreetingText(
                message = message,
                from = from,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun BirthdayCardPreview() {
        GoogleBasicsWithComposeTheme {
            GreetingImage(
                message = "Happy Android!",
                from = "- from Dev"
            )
        }
    }
}