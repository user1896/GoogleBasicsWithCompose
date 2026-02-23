package com.example.googlebasicswithcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.googlebasicswithcompose.ui.theme.GoogleBasicsWithComposeTheme


class MainActivity : ComponentActivity() {
    //  onCreate() function is the entry point.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    //  The setContent() function within the onCreate() function is used to
    //  define the layout through composable functions. All functions marked
    //  with the @Composable annotation can be called from the setContent()
    //  function or from other Composable functions.
    setContent {
            GoogleBasicsWithComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "User",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// The @Composable annotation tells the Kotlin compiler that this function
// is used by Jetpack Compose to generate the UI.
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    //  @Composable function names are capitalized.

    // Surface is a component that you can think of as a paper, it provides
    // a background, and can also handle "elevation" (shadows) and "shape"
    // (rounded corners). Anything inside the curly braces { ... } will be
    // drawn on top of it.
    Surface(color = Color.Red) {
    // Text is our second component, is it the basic "TextView" of Compose.
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }
    //  @Composable functions can't return anything.
}

// a preview of a composable lets us see what the composable looks like
// without having to build the entire app.
// To enable a preview, annotate with @Composable and @Preview
// We can't just use @Preview, we have to also use @Composable as well,
// because this is a function of its own (we call it here GreetingPreview())
// that we can compose from it other things.
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GoogleBasicsWithComposeTheme {
        Greeting("User")
    }
}