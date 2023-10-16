package com.appisKey_assessment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.appisKey_assessment.data.Hits
import com.appisKey_assessment.data.PixHelper
import com.appisKey_assessment.databinding.PixItemLayoutBinding
import com.bumptech.glide.Glide
import javax.inject.Inject

class PixAdapter @Inject constructor() :  ListAdapter<Hits, RecyclerView.ViewHolder>(SliderDiffCallback) {
    var itemClickListener: ((obj: Hits) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view= PixItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PixViewHolder(view)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        with(holder as PixAdapter.PixViewHolder) { bindData(getItem(adapterPosition)) }

    }



   inner class PixViewHolder(var view: PixItemLayoutBinding): RecyclerView.ViewHolder(view.root){

        fun bindData(item: Hits) {
            Glide.with(view.imageView).load(item.largeImageURL).into(view.imageView)
            view.likes.text="Likes: ${item.likes}"
            view.tags.text="${item.tags}"
            view.user.text="${item.user}"
            view.root.setOnClickListener {
                itemClickListener?.invoke(item)
            }
        }
    }

    object SliderDiffCallback : DiffUtil.ItemCallback<Hits>() {

        override fun areItemsTheSame(oldItem: Hits, newItem: Hits): Boolean {
            return false
        }

        override fun areContentsTheSame(oldItem: Hits, newItem: Hits): Boolean {
            return false
        }

    }

}