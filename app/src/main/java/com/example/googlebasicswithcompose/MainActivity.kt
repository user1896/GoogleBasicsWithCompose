package com.example.googlebasicswithcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.googlebasicswithcompose.ui.theme.GoogleBasicsWithComposeTheme
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoogleBasicsWithComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    LemonadeAppLayout()
                }
            }
        }
    }
}

// Compose Material 3 considers certain layout components "Experimental" like Scafold,
// we "opt-in" to the API by adding: @OptIn(ExperimentalMaterial3Api::class)
// This tells Android Studio you know it’s experimental, and you're okay with it.
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeAppLayout() {
    var stageState by remember { mutableIntStateOf(1) }

    var currentImageSrc = R.drawable.lemon_tree
    var currentImageDescription = R.string.lemon_tree
    var currentTextValue = R.string.lemon_tree_description

    when (stageState) {
        2 -> {
            currentImageSrc = R.drawable.lemon_squeeze
            currentImageDescription = R.string.lemon
            currentTextValue = R.string.lemon_squeeze_description
        }
        3 -> {
            currentImageSrc = R.drawable.lemon_drink
            currentImageDescription = R.string.glass_of_lemonade
            currentTextValue = R.string.lemon_drink_description
        }
        4 -> {
            currentImageSrc = R.drawable.lemon_restart
            currentImageDescription = R.string.empty_glass
            currentTextValue = R.string.lemon_restart_description
        }
        else -> {
            stageState = 1
        }
    }

    // Scaffold manages the "slots" for your UI. It gives you slots like topBar, bottomBar,
    // floatingActionButton, and passes innerPadding so your content does not draw under those
    // bars. Without it, you have to guess or manually calculate those offsets.

    // Use Scaffold when your screen needs Material structure like a top bar, bottom bar, FAB,
    // snackbars, or proper handling of system insets
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Lemonade",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = Color(0xFFC3ECD2)
                )
            )
        }
    ) { innerPadding -> // the innerPadding tells you how much space is already being used by things like the top bar or bottom bar, and you apply that padding to your main content so it doesn’t overlap them.
        // Surface is optional and mainly useful for applying Material background/color/shadow
        // and making a container follow the Material look.
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            color = MaterialTheme.colorScheme.background
        )
        {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 40.dp)
                    .verticalScroll(rememberScrollState()) // verticalScroll makes a Composable scrollable when its content is too tall to fit on the screen. rememberScrollState() "remembers" the current scroll position to ensures that if the screen rotates or the user leaves and comes back, the scroll position isn't lost.
                    .safeDrawingPadding(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                LemonadeStage(
                    imageSrc = currentImageSrc,
                    imageDescription = currentImageDescription,
                    textValue = currentTextValue,
                    onImageClick = {
                        stageState++
                    }
                )
            }
        }
    }
}

@Composable
fun LemonadeStage(
    @DrawableRes imageSrc: Int,
    @StringRes imageDescription: Int,
    @StringRes textValue: Int,
    onImageClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(RoundedCornerShape(32.dp)) // 1. Clip to a rounded shape
            .background(Color(0xFFC3ECD2)) // In Compose, the order is critical: first you define the "shape" of the container (clipping), then you fill that shape with color
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(imageSrc),
            contentDescription = stringResource(imageDescription),
            modifier = Modifier
                .wrapContentSize()
                .clickable(
                    onClick = onImageClick
                )
                .padding(bottom = 16.dp)
        )
        Text(
            text = stringResource(textValue),
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            color = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TipTimeLayoutPreview() {
    GoogleBasicsWithComposeTheme {
        LemonadeAppLayout()
    }
}