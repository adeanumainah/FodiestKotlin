package com.dean.fodiestkotlin.viewmodel

import com.dean.fodiestkotlin.AppBaseInterface
import com.dean.fodiestkotlin.model.foods.MealsItem

class MealsViewModel (private var view:AppBaseInterface<List<MealsItem>>?): OnFinishedListener<List<MealsItem>> {

    override fun success(data: List<MealsItem>) {
        view?.hideProgressBar()
        view?.showData()
    }

    override fun failure(message: String?) {
        view?.hideProgressBar()
        view?.showError(message)
    }
}