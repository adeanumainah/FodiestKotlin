package com.dean.fodiestkotlin.model.foods

import com.google.gson.annotations.SerializedName

data class ResponseFoods(

	@field:SerializedName("meals")
	val meals: List<MealsItem?>? = null
)