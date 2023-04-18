package com.example.android_2_ls_2.ui.fragments.onBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.android_2_ls_2.R
import com.example.android_2_ls_2.databinding.FragmentOnBoardBinding
import com.example.android_2_ls_2.ui.adapter.OnBoardAdapter
import com.example.android_2_ls_2.utls.PreferenceHelper

class OnBoardFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
    }

    private fun initialize() {
        binding.viewPager2.adapter = OnBoardAdapter(this@OnBoardFragment)
        binding.dots.attachTo(binding.viewPager2)
    }

    private fun setupListener() = with(binding) {
        txtNext.setOnClickListener {
            with(viewPager2) {
                if (currentItem < 2) {
                    setCurrentItem(viewPager2.currentItem + 1, true)
                }
            }
        }

        binding.startTxt.setOnClickListener {
            val preferenceHelper = PreferenceHelper()
            preferenceHelper.unit(requireContext())
            preferenceHelper.onSaveOnBoardState = false
            findNavController().navigate(R.id.action_onBoardFragment_to_homeFragment)
        }

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        txtNext.isVisible = true
                        startTxt.isVisible = false
                    }
                    1 -> {
                        txtNext.isVisible = true
                        startTxt.isVisible = false
                    }
                    2 -> {
                        txtNext.isVisible = false
                        startTxt.isVisible = true
                    }
                }

                super.onPageSelected(position)
            }
        })
    }
}

