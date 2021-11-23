package com.mistpaag.mealzapp.ui.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.mistpaag.mealzapp.model.response.MealResponse

@Composable
fun MealDetailsScreen(meal: MealResponse?) {
    Column {
        Row {
            Card {
                Image(
                    painter = rememberImagePainter(
                        meal?.imageUrl,
                        builder = {
                            transformations(CircleCropTransformation())
                        }
                    ),
                    contentDescription = "",
                    modifier = Modifier.size(200.dp)
                )
            }
            Text(text = meal?.name ?: "")
        }
        Button(onClick = {}) {
            Text(text = "Change state of meal profile picture")
        }
    }
}