package com.dean.fodiestkotlin.viewmodel

interface OnFinishedListener<T> {
    fun success(data: T)
    fun failure(message : String?)

}
