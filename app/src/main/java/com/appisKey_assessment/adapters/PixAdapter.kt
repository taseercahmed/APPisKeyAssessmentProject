package com.appisKey_assessment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.appisKey_assessment.PixHelper
import com.appisKey_assessment.databinding.PixItemLayoutBinding
import javax.inject.Inject

class PixAdapter @Inject constructor() :  ListAdapter<PixHelper, RecyclerView.ViewHolder>(SliderDiffCallback) {
    var itemClickListener: ((position: Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view= PixItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PixViewHolder(view)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        with(holder as PixAdapter.PixViewHolder) { bindData(getItem(adapterPosition)) }

    }

    class PixViewHolder(view: PixItemLayoutBinding): RecyclerView.ViewHolder(view.root){

        fun bindData(model: PixHelper) {

        }
    }

    object SliderDiffCallback : DiffUtil.ItemCallback<PixHelper>() {

        override fun areItemsTheSame(oldItem: PixHelper, newItem: PixHelper): Boolean {
            return false
        }

        override fun areContentsTheSame(oldItem: PixHelper, newItem: PixHelper): Boolean {
            return false
        }

    }

}