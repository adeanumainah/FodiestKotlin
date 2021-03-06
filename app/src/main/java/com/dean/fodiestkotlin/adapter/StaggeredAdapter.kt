package com.dean.fodiestkotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dean.fodiestkotlin.R
import com.dean.fodiestkotlin.model.Foods
import kotlinx.android.synthetic.main.item_staggered.view.*

class StaggeredAdapter(private val listStaggered: ArrayList<Foods>) :
    RecyclerView.Adapter<StaggeredAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_staggered, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listStaggered.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listStaggered[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(foods: Foods) {
            with(itemView) {
                Glide.with(itemView.context).load(foods.images)
                    .apply(RequestOptions().override(500))
                    .into(iv_staggered_name)

                tv_staggered_name.text = foods.name
                tv_staggered_kind.text = foods.kind
                tv_staggered_address.text = foods.address
                tv_staggered_desc.text = foods.desc
            }
        }

    }
}