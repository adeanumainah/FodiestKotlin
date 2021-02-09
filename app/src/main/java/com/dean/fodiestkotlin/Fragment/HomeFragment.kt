package com.dean.fodiestkotlin.Fragment


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.dean.fodiestkotlin.activity.DetailFoodActivity
import com.dean.fodiestkotlin.adapter.FoodAdapter
import com.dean.fodiestkotlin.R
import com.dean.fodiestkotlin.activity.AllPopularActivity
import com.dean.fodiestkotlin.model.Foods
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {
//    private val foodList = ArrayList<Foods>()
      private lateinit var foodAdapter: FoodAdapter

    companion object {
        fun defaultFragment(): HomeFragment {
            val homeFragment = HomeFragment()
            val bundle = Bundle()
            homeFragment.arguments = bundle
            return homeFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    val imageContentSlider = intArrayOf(
        R.drawable.landscape1,
        R.drawable.landscape2,
        R.drawable.landscape3,
        R.drawable.landscape4,
        R.drawable.landscape5
    )

    val imageContentListener: ImageListener = object : ImageListener {
        override fun setImageForPosition(position: Int, imageView: ImageView) {
            imageView.setImageResource(imageContentSlider[position])
            //glide
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val carouselView = is_main as CarouselView
        carouselView.setImageListener(imageContentListener)
        carouselView.setPageCount(imageContentSlider.count())
        showRecyclerList()

        tv_see_all.setOnClickListener {
            val list = Intent(context, AllPopularActivity::class.java)
            startActivity(list)
        }

    }



    private fun showRecyclerList() {
        foodAdapter = FoodAdapter { showSelected(it) }
        foodAdapter.notifyDataSetChanged()
        foodAdapter.setData(getListFood())
        rv_popular.setHasFixedSize(true)
        rv_popular.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rv_popular.adapter = foodAdapter
    }

    private fun showSelected(it: Foods) {
        val page = Intent(context, DetailFoodActivity::class.java)
        page.putExtra(DetailFoodActivity.KEY_POPULAR_FOOD, it)
        startActivity(page)
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
}
