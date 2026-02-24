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
import androidx.compose.ui.unit.dp
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
                // The Scaffold container (a composable function) is used
                // for the Overall page structure/skeleton.
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Google's official Jetpack Compose documentation
                    // recommends Scaffold as the top-level container for
                    // any "Screen" in the app.

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
    Surface(
        color = Color.Cyan,
        modifier = modifier.padding(2.dp) // we apply the "incoming" modifier to the outermost component of the function
        // The Scaffold (in MainActivity) calculates innerPadding
        // (Without this, your text might get cut off by the phone's
        // notch or the "Back/Home" gesture bar.).
        // It passes that padding into Greeting via the modifier parameter.
        // We then add 2.dp of extra padding on top of that.
    ) {
        // Text is our second component, is it the basic "TextView" of Compose.
        Text(
            text = "Hello $name!",
            // a Modifier is essentially a list of decorations
            // (padding, color, size) that we apply to UI elements.
            modifier = Modifier.padding(24.dp)
            // When you use the capital "M" Modifier, you are creating
            // a brand new, empty list. It ignores any previous settings
            // or constraints (that are in the parameter "modifier"),
            // and applies only 24dp of padding.
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