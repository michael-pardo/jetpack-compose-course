package com.mistpaag.mealzapp.ui.meals

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import com.mistpaag.mealzapp.model.MealsRepository
import com.mistpaag.mealzapp.model.response.MealResponse
import com.mistpaag.mealzapp.model.response.MealsCategoriesResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MealsCategoriesViewModel(
    private val repository: MealsRepository = MealsRepository()
): ViewModel() {

    private val mealsJob = Job()

    init {
        val scope = CoroutineScope(mealsJob + Dispatchers.IO)
        scope.launch {
            val meals = getMeals()
            mealsState.value = meals
        }
    }

    val mealsState = mutableStateOf(emptyList<MealResponse>())


    suspend fun getMeals(): List<MealResponse> {
        return repository.getMeals().categories
    }

    override fun onCleared() {
        super.onCleared()
        mealsJob.cancel()
    }

}