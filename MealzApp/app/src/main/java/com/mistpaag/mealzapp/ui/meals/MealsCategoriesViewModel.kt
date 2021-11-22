package com.mistpaag.mealzapp.ui.meals

import androidx.lifecycle.ViewModel
import com.mistpaag.mealzapp.model.MealsRepository
import com.mistpaag.mealzapp.model.response.MealResponse
import com.mistpaag.mealzapp.model.response.MealsCategoriesResponse

class MealsCategoriesViewModel(
    private val repository: MealsRepository = MealsRepository()
): ViewModel() {


    fun getMeals(successCallback: (response: MealsCategoriesResponse?) -> Unit) {
        return repository.getMeals{
            successCallback(it)
        }
    }

}