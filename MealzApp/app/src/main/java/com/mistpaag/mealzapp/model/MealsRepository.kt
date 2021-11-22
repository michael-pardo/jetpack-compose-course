package com.mistpaag.mealzapp.model

import com.mistpaag.mealzapp.model.response.MealsCategoriesResponse

class MealsRepository {

    fun getMeals(): MealsCategoriesResponse = MealsCategoriesResponse(arrayListOf())
}