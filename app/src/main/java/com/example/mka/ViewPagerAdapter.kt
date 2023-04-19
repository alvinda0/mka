package com.example.mka

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(
    fragmentList: ArrayList<Fragment>,
    supportFragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(supportFragmentManager, lifecycle){

        private val fragmentList = fragmentList

        override fun getItemCount(): Int {
            return fragmentList.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragmentList[position]
        }
}
