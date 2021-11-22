package com.mistpaag.mealzapp.ui.meals

import androidx.lifecycle.ViewModel
import com.mistpaag.mealzapp.model.MealsRepository
import com.mistpaag.mealzapp.model.response.MealResponse

class MealsCategoriesViewModel(
    private val repository: MealsRepository = MealsRepository()
): ViewModel() {


    fun getMeals() : List<MealResponse> {
        return repository.getMeals().categories
    }

}