package com.example.android_2_ls_2.ui.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.android_2_ls_2.ui.fragments.onBoard.OnBoardPagingFragment

class OnBoardAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment = OnBoardPagingFragment().apply {
        arguments = Bundle().apply {
            putInt(OnBoardPagingFragment.ARG_ON_BOARD_PAGE_POSITION, position)
        }
    }
}