package com.mistpaag.mealzapp.model.response

import com.google.gson.annotations.SerializedName

data class MealsCategoriesResponse(
    @SerializedName("categories") val categories: List<MealResponse>
)