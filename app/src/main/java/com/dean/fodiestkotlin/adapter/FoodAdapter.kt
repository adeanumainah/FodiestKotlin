package com.dean.fodiestkotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dean.fodiestkotlin.R
import com.dean.fodiestkotlin.model.Foods
import kotlinx.android.synthetic.main.item_row.view.*

class FoodAdapter(private val listener: (Foods) -> Unit)
    : RecyclerView.Adapter<FoodAdapter.ViewHolder>() {
     private val listFoods = ArrayList<Foods>()

    fun setData(items: ArrayList<Foods>){
        listFoods.clear()
        listFoods.addAll(items)
        //mensyncron data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listFoods.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listFoods[position], listener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(foods: Foods, listener: (Foods) -> Unit) {
            with(itemView) {
                Glide.with(itemView.context).load(foods.images)
                    .apply(RequestOptions().override(300)).into(iv_popular)

                tv_name_restaurant.setText(foods.name)
                tv_address.setText(foods.address)
                tv_kind.setText(foods.kind)

                itemView.setOnClickListener { listener(foods) }
            }
        }

    }
}