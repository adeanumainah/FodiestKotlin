package com.dean.fodiestkotlin.source

import android.database.Observable
import com.dean.fodiestkotlin.model.foods.ResponseFoods
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiSercvices {
    @GET("filter.php?c=Seafood")
//    fun getListFood():Observable<ResponseFoods>
    fun getListFood():io.reactivex.Observable<ResponseFoods?>
}