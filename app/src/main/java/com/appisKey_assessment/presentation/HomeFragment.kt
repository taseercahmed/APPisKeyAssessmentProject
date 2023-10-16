package com.appisKey_assessment.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.appisKey_assessment.R
import com.appisKey_assessment.adapters.PixAdapter
import com.appisKey_assessment.data.Hits
import com.appisKey_assessment.viewmodels.PixViewModel
import com.appisKey_assessment.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import java.lang.StringBuilder
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private var mRootView: ViewGroup? = null
    private val viewModel by viewModels<PixViewModel>()
    @Inject
    lateinit var pixAdapter: PixAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        mRootView = binding?.root
        return mRootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.DataRec?.adapter=pixAdapter
        pixAdapter.itemClickListener=::onClickItem

        viewModel.livePixList.observe(requireActivity()){
            pixAdapter.submitList(it)
        }
        binding?.problemSolving?.setOnClickListener {
            var str=binding?.enterString?.text.toString()
            val wordCounts = findCount(str)
            var resultStr= StringBuilder()
            for ((word, count) in wordCounts) {
                resultStr.append("$word: $count \n")
            }
            binding?.problemSolving?.text="Result is ${resultStr}"
        }

    }

    private fun onClickItem(hits: Hits){
            viewModel.setSelectedHit(hits)
          findNavController().navigate(R.id.action_homeFragment_to_imageDetailFragment)
    }

    private fun findCount(str: String): Map<String, Int> {
        val words = str.split(Regex("\\W+"))
        val wordCount = mutableMapOf<String, Int>()

        for (word in words) {
            val lowercaseWord = word.toLowerCase()
            if (lowercaseWord.isNotEmpty()) {
                wordCount[lowercaseWord] = wordCount.getOrDefault(lowercaseWord, 0) + 1
            }
        }

        return wordCount
    }

}