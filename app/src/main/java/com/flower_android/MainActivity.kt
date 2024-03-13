package com.flower_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.flower_android.databinding.ActivityMainBinding
import com.flower_android.fragment.AllFragment
import com.flower_android.fragment.BasketFragment
import com.flower_android.fragment.BouquetFragment
import com.flower_android.fragment.OneFlowerFragment
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val allFragment = AllFragment()
    private val list: List<Fragment> = listOf(allFragment, OneFlowerFragment(), BouquetFragment(), BasketFragment())
    private val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle, list)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.view = this
        initView()
    }

    private fun initView() {
        binding.viewPager.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = if(list[position] is AllFragment) {
                "전체"
            }else if(list[position] is OneFlowerFragment) {
                "한송이"
            }else if(list[position] is BouquetFragment) {
                "꽃다발"
            }else {
                "바구니"
            }
        }.attach()
    }
}