package com.flower_android

import android.graphics.Bitmap
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.flower_android.databinding.ActivityDetailBinding
import com.flower_android.list.option.OptionAdapter
import com.flower_android.list.option.OptionItemHandler
import com.flower_android.model.CommonItem
import com.flower_android.model.ImageProvider
import com.flower_android.model.MenuItem
import com.flower_android.model.OptionProvider

class DetailActivity : AppCompatActivity(), ImageProvider.Callback, OptionProvider.Callback {
    private lateinit var binding: ActivityDetailBinding

    private lateinit var categoryAdapter: OptionAdapter
    private lateinit var etcAdapter: OptionAdapter
    private lateinit var wrapAdapter: OptionAdapter
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
        categoryAdapter = OptionAdapter(Handler(), binding.categoryRecyclerView)
        etcAdapter = OptionAdapter(Handler(), binding.etcRecyclerView)
        wrapAdapter = OptionAdapter(Handler(), binding.wrapRecyclerView)
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
        if (count > 1) {
            count--
            binding.countTextView.text = "$count"
            binding.priceTextView.text = "${item.price!!.times(count)}원"
        }
    }

    fun onPlus(item: MenuItem) {
        if (count < 9) {
            count++
            binding.countTextView.text = "$count"
            binding.priceTextView.text = "${item.price!!.times(count)}원"
        }
    }

    inner class Handler : OptionItemHandler {
        override fun onClickItem(item: CommonItem, position: Int) {

        }

    }
}