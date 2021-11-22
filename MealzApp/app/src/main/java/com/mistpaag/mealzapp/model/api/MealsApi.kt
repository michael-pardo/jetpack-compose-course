package com.mistpaag.mealzapp.model.api

import com.mistpaag.mealzapp.model.response.MealsCategoriesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.Retrofit




class MealsWebService {

    private lateinit var api: MealsApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(MealsApi::class.java)
    }

    fun getMeals(): Call<MealsCategoriesResponse> {
        return api.getMeals()
    }

    interface MealsApi{
        @GET("categories.php")
        fun getMeals(): Call<MealsCategoriesResponse>
    }
}