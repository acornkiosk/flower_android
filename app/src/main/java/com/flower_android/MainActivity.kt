package com.flower_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.flower_android.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val allFragment = AllFragment()
    private val list = listOf(allFragment, OneFlowerFragment(), BouquetFragment(), BasketFragment())
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