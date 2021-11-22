package com.mistpaag.mealzapp.model

import com.mistpaag.mealzapp.model.api.MealsWebService
import com.mistpaag.mealzapp.model.response.MealsCategoriesResponse

class MealsRepository(
    private val webService: MealsWebService = MealsWebService()
) {

    fun getMeals(): MealsCategoriesResponse? {
        return webService.getMeals().execute().body()
    }
}