package com.ridennator.fragments2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.Tab
import com.ridennator.fragments2.fragmentos.fragment1
import com.ridennator.fragments2.fragmentos.fragment2
import com.ridennator.fragments2.fragmentos.fragment3

class MainActivity : AppCompatActivity() {
    lateinit var tabLayout:TabLayout
    lateinit var viewPager2: ViewPager2
    lateinit var myViewPagerAdapter: MyViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tab_layout)
        viewPager2 = findViewById(R.id.view_pager2)
        myViewPagerAdapter = MyViewPagerAdapter(this)
        viewPager2.adapter = myViewPagerAdapter
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: Tab?) {
                viewPager2.currentItem = tab!!.position
            }
            override fun onTabUnselected(tab: Tab?) { }
            override fun onTabReselected(tab: Tab?) { }
        })
        viewPager2.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabLayout.getTabAt(position)?.select()
            }
        })
    }


    class MyViewPagerAdapter(fragmentActivity: FragmentActivity) :
        FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int {
            return 3
        }

        override fun createFragment(position: Int): Fragment {
            when (position) {
                0 -> return fragment1()
                1 -> return fragment2()
                2 -> return fragment3()
                else -> return fragment1()
            }
        }
    }
}