package com.mistpaag.mealzapp.ui.meals

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mistpaag.mealzapp.model.MealsRepository
import com.mistpaag.mealzapp.model.response.MealResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealsCategoriesViewModel(
    private val repository: MealsRepository = MealsRepository()
): ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val meals = getMeals()
            mealsState.value = meals
        }
    }

    val mealsState = mutableStateOf(emptyList<MealResponse>())


    suspend fun getMeals(): List<MealResponse> {
        return repository.getMeals().categories
    }

}