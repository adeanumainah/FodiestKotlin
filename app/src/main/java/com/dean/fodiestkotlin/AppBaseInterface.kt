package com.dean.fodiestkotlin

interface AppBaseInterface<T> {
    fun hideProgressBar()
    fun showData()
    fun showError(message: String?)
}