package com.appisKey_assessment.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.appisKey_assessment.R
import com.appisKey_assessment.databinding.FragmentHomeBinding
import com.appisKey_assessment.databinding.FragmentImageDetailBinding
import com.appisKey_assessment.viewmodels.PixViewModel
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ImageDetailFragment : Fragment() {
    private val viewModel by viewModels<PixViewModel>()
    private lateinit var binding: FragmentImageDetailBinding
    private var mRootView: ViewGroup? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentImageDetailBinding.inflate(layoutInflater)
        mRootView = binding?.root
        return mRootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var item=viewModel.getSelectedHit()
        Glide.with(binding?.largeImage!!).load(item?.largeImageURL).into(binding?.largeImage!!)

    }

}