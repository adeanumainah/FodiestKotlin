package com.dean.fodiestkotlin.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Foods (
    var name: String,
    var address:String,
    var kind:String,
    var desc:String,
    var images: Int

): Parcelable