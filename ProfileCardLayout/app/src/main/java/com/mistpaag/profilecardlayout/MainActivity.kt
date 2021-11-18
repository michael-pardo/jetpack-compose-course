package com.mistpaag.profilecardlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.mistpaag.profilecardlayout.ui.theme.ProfileCardLayoutTheme
import com.mistpaag.profilecardlayout.ui.theme.lightGreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileCardLayoutTheme {
                UserListScreen(userProfiles = userProfileList)
            }
        }
    }
}

@Composable
fun UserListScreen(userProfiles: List<UserProfile> = userProfileList) {
    Scaffold(
        topBar = { AppBar() }
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            LazyColumn {
                items(userProfiles){ userProfile->
                    ProfileCard(userProfile = userProfile)
                }
            }
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
fun ProfileCard(userProfile: UserProfile){
    Card(
        modifier = Modifier
            .padding(top = 8.dp, bottom = 4.dp, start = 16.dp, end = 16.dp)
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
            ProfilePicture(userProfile.pictureUrl, userProfile.status, 72.dp)
            ProfileContent(userProfile.name, userProfile.status, Alignment.Start)
        }
    }
}

@Composable
fun ProfilePicture(pictureUrl: String, onlineStatus: Boolean, imageSize: Dp) {
    Card(
        shape = CircleShape,
        border = BorderStroke(
            width = 2.dp,
            color = if (onlineStatus) MaterialTheme.colors.lightGreen else Color.Red
        ),
        modifier = Modifier.padding(16.dp),
        elevation = 4.dp,
    ) {
        Image(
            painter = rememberImagePainter(
                pictureUrl,
                builder = {
                    transformations(CircleCropTransformation())
                },
            ),
            contentDescription = "Content description",
            modifier = Modifier.size(imageSize),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun ProfileContent(name: String, onlineStatus: Boolean, alignment: Alignment.Horizontal) {
    Column(
        modifier = Modifier
            .padding(8.dp),
        horizontalAlignment = alignment
    ) {
        CompositionLocalProvider(LocalContentAlpha provides if (onlineStatus) 1f else ContentAlpha.disabled) {
            Text(
                text = name,
                style = MaterialTheme.typography.h5,
            )
        }

        CompositionLocalProvider( LocalContentAlpha provides ContentAlpha.medium){
            Text(
                text = if (onlineStatus) "Active now" else "Offline",
                style = MaterialTheme.typography.body2,
            )
        }

    }
}

@Composable
fun UserProfileDetailScreen(userProfile: UserProfile = userProfileList[0]) {
    Scaffold(
        topBar = { AppBar() }
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                ProfilePicture(userProfile.pictureUrl, userProfile.status, 240.dp)
                ProfileContent(userProfile.name, userProfile.status, Alignment.CenterHorizontally)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserProfileDetailsPreview() {
    ProfileCardLayoutTheme {
        UserProfileDetailScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProfileCardLayoutTheme {
        UserListScreen()
    }
}