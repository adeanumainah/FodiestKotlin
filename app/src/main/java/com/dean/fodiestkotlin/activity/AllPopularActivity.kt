package com.dean.fodiestkotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.dean.fodiestkotlin.R
import com.dean.fodiestkotlin.adapter.StaggeredAdapter
import com.dean.fodiestkotlin.model.Foods
import kotlinx.android.synthetic.main.activity_see_all_popular.*

class AllPopularActivity : AppCompatActivity() {
    private val listFood = ArrayList<Foods>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_see_all_popular)
        supportActionBar?.hide()

        rv_all_popular.setHasFixedSize(true)
        listFood.addAll(getListFood())
        showRecyclerGrid()
    }


    fun getListFood(): ArrayList<Foods> {
        val dataName = resources.getStringArray(R.array.data_food)
        val dataAddress = resources.getStringArray(R.array.data_addres)
        val dataKind = resources.getStringArray(R.array.data_kind)
        val dataDesc = resources.getStringArray(R.array.data_desc)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)

        //u meluping
        val listFood = ArrayList<Foods>()

        for (position in dataName.indices) {
            val food = Foods(
                dataName[position],
                dataAddress[position],
                dataKind[position],
                dataDesc[position],
                dataPhoto.getResourceId(position, -1)
            )
            listFood.add(food)
        }
        return listFood

    }

    private fun showRecyclerGrid() {
        val layoutManagerStaggered = StaggeredGridLayoutManager(2, GridLayoutManager.VERTICAL)
        rv_all_popular.layoutManager =layoutManagerStaggered
        rv_all_popular.adapter = StaggeredAdapter(listFood)
    }
}
