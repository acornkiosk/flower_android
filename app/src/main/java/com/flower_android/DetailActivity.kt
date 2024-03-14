package com.flower_android

import android.graphics.Bitmap
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.flower_android.databinding.ActivityDetailBinding
import com.flower_android.list.OptionAdapter
import com.flower_android.model.CommonItem
import com.flower_android.model.ImageProvider
import com.flower_android.model.MenuItem
import com.flower_android.model.OptionProvider

class DetailActivity : AppCompatActivity(), ImageProvider.Callback, OptionProvider.Callback {
    private lateinit var binding: ActivityDetailBinding

    private val categoryAdapter by lazy { OptionAdapter() }
    private val etcAdapter by lazy { OptionAdapter() }
    private val wrapAdapter by lazy { OptionAdapter() }
    private val optionProvider = OptionProvider(this)
    private val imageProvider = ImageProvider(this)
    private var count = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.view = this
        val item = intent.getSerializableExtra("item") as MenuItem
        binding.item = item
        optionProvider.getOption(item.category_id ?: 0, "category")
        optionProvider.getOption(2012, "etc")
        optionProvider.getOption(2016, "wrap")
        initView(item)
    }

    private fun initView(item: MenuItem) {
        imageProvider.getImage(item.img_name ?: "")
        binding.apply {
            menuNameTextView.text = item.name
            summaryTextView.text = item.summary
            descriptionTextView.text = item.description
            priceTextView.text = "${item.price}원"
            when (item.category_id) {
                1001 -> {
                    binding.categoryTextView.text = "한송이 옵션"
                }

                1002 -> {
                    binding.categoryTextView.text = "꽃다발 옵션"
                }

                else -> {
                    binding.categoryTextView.text = "바구니 옵션"
                }
            }
            categoryRecyclerView.adapter = categoryAdapter
            etcRecyclerView.adapter = etcAdapter
            wrapRecyclerView.adapter = wrapAdapter
        }
    }

    override fun getImage(bitmap: Bitmap) {
        binding.menuImageView.setImageBitmap(bitmap)
    }

    override fun getOption(list: List<CommonItem>, type: String?) {
        when (type) {
            "category" -> {
                categoryAdapter.submitList(list)
            }

            "etc" -> {
                etcAdapter.submitList(list)
            }

            else -> {
                wrapAdapter.submitList(list)
            }
        }
    }

    fun onMinus(item: MenuItem) {
        if(count > 1) {
            count--
            binding.countTextView.text = "$count"
            binding.priceTextView.text = "${item.price!!.times(count)}원"
        }
    }

    fun onPlus(item: MenuItem) {
        if(count < 9) {
            count++
            binding.countTextView.text = "$count"
            binding.priceTextView.text = "${item.price!!.times(count)}원"
        }
    }
}