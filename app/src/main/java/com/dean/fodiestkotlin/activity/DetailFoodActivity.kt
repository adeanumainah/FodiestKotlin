package com.dean.fodiestkotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dean.fodiestkotlin.R
import com.dean.fodiestkotlin.model.Foods
import kotlinx.android.synthetic.main.activity_detail_food.*

class DetailFoodActivity : AppCompatActivity() {

    companion object{
        const val KEY_POPULAR_FOOD = "key_popular_food"
    }

    private var foods: Foods? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_food)
        foods = intent.getParcelableExtra(KEY_POPULAR_FOOD)

        tv_name_detail.text = foods?.name
        tv_description_detail.text = foods?.desc
        tv_kind_detail.text = foods?.kind
        tv_address_detail.text = foods?.address
        Glide.with(this).load(foods?.images).apply(RequestOptions()).override(500)
            .into(iv_detail)

    }
}
