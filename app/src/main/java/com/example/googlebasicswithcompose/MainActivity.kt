package com.example.googlebasicswithcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                // The Scaffold container (a composable function) is used
                // for the Overall page structure/skeleton.
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                Surface(
                    modifier = Modifier.padding(innerPadding),
                    color = MaterialTheme.colorScheme.background
                ) {
                }
            }
        }
    }
}

@Composable
fun GreetingText(modifier: Modifier = Modifier, message: String = "Hello", from: String = "Sender") {
    Column(modifier = modifier) { // instead of arranging our components as a Column, we could use Row or Box.
        Text(
            text = "$message!",
            fontSize = 30.sp, // "sp" resizes based on the user's preferred text size under phone settings.
            lineHeight = 116.sp,
        )
        Text(
            text = from,
            fontSize = 26.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GoogleBasicsWithComposeTheme {
        GreetingText(message = "Happy Android", from = "Developer")
    }
    }
}