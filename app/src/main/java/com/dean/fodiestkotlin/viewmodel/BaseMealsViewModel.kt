package com.dean.fodiestkotlin.viewmodel

import com.dean.fodiestkotlin.model.foods.MealsItem
import com.dean.fodiestkotlin.model.foods.ResponseFoods
import com.dean.fodiestkotlin.source.ApiSercvices
import com.dean.fodiestkotlin.source.RetrofitConfig
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class BaseMealsViewModel(private val listener:OnFinishedListener<List<MealsItem>>) {
    private val compositeDisposable = CompositeDisposable()
    fun fetchMealsData(meals: String){
        compositeDisposable.add(
            RetrofitConfig.apiServicesClient
                .getListFood().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleNext,this::handleError)
        )
    }
    private fun handleNext(mealItem : ResponseFoods){
        val mealsItem = mealItem.meals
        listener.success(mealsItem as List<MealsItem>)
    }

    private fun handleError(throwable: Throwable){
        listener.failure(throwable.message)
    }
}