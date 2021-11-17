package com.mistpaag.profilecardlayout

import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mistpaag.profilecardlayout.ui.theme.ProfileCardLayoutTheme
import com.mistpaag.profilecardlayout.ui.theme.lightGreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileCardLayoutTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    Scaffold(
        topBar = { AppBar() }
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            ProfileCard()
        }
    }
}

@Composable
fun AppBar(){
    TopAppBar(
        navigationIcon = {
            Icon(
                Icons.Default.Home,
                contentDescription = "icon",
                modifier = Modifier.padding(horizontal = 12.dp)
            )},
        title = { Text("Messaging Application Users") }
    )
}

@Composable
fun ProfileCard(){
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top),
        elevation = 8.dp,
        backgroundColor = Color.White
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            ProfilePicture()
            ProfileContent()
        }
    }
}

@Composable
fun ProfilePicture() {
    Card(
        shape = CircleShape,
        border = BorderStroke(
            width = 2.dp,
            color = MaterialTheme.colors.lightGreen
        ),
        modifier = Modifier.padding(16.dp),
        elevation = 4.dp,
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = "Content description",
            modifier = Modifier.size(68.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun ProfileContent() {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "John Doe",
            style = MaterialTheme.typography.h5,
        )

        Text(
            text = "Active now",
            style = MaterialTheme.typography.body2,
        )

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProfileCardLayoutTheme {
        MainScreen()
    }
}