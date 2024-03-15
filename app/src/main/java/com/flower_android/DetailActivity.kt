package com.flower_android

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.flower_android.databinding.ActivityDetailBinding
import com.flower_android.list.option.OptionAdapter
import com.flower_android.list.option.OptionItemHandler
import com.flower_android.model.CommonItem
import com.flower_android.model.ImageProvider
import com.flower_android.model.MenuItem
import com.flower_android.model.OptionProvider
import com.flower_android.model.OrderItem
import com.flower_android.util.OrderId
import com.flower_android.util.PreferenceUtil

class DetailActivity : AppCompatActivity(), ImageProvider.Callback, OptionProvider.Callback {
    private lateinit var binding: ActivityDetailBinding

    private lateinit var categoryAdapter: OptionAdapter
    private lateinit var etcAdapter: OptionAdapter
    private lateinit var wrapAdapter: OptionAdapter
    private val optionProvider = OptionProvider(this)
    private val imageProvider = ImageProvider(this)
    private var count = 1
    private var order = OrderItem()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.view = this
        val item = intent.getSerializableExtra("item") as MenuItem
        order.menu_name = item.name
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
            order.menu_count = count
        }
    }

    fun onPlus(item: MenuItem) {
        if (count < 9) {
            count++
            binding.countTextView.text = "$count"
            binding.priceTextView.text = "${item.price!!.times(count)}원"
            order.menu_count = count
        }
    }

    fun onClose() {
        finish()
    }

    fun addOrder() {
        val intent = Intent(this,MainActivity::class.java)
        PreferenceUtil(this).setOrder(OrderId.id.toString(),order)
        OrderId.increase()
        startActivity(intent)
        finish()
    }

    inner class Handler : OptionItemHandler {
        override fun onClickItem(item: CommonItem, checked: Boolean) {
            if (item.p_code_id == 2012) {
                if (checked) {
                    order.options += "${item.code_id}, "
                    order.optionsText += "${item.code_name}, "
                } else {
                    order.options = order.options?.replace("${item.code_id}, ", "")
                    order.optionsText = order.optionsText?.replace("${item.code_name}, ", "")
                }
            } else if (item.p_code_id == 1001) {
                order.options = order.options?.replace("2001, ", "")?.replace("2002, ", "")
                    ?.replace("2003, ", "") + "${item.code_id}, "
                order.optionsText =
                    order.optionsText?.replace("종이포장지, ", "")?.replace("반투명포장지, ", "")
                        ?.replace("유산지포장지, ", "") + "${item.code_name}, "
            }else if(item.p_code_id == 1002){
                order.options = order.options?.replace("2005, ", "")?.replace("2006, ", "")
                    ?.replace("2007, ", "") + "${item.code_id}, "
                order.optionsText =
                    order.optionsText?.replace("종이포장지, ", "")?.replace("반투명포장지, ", "")
                        ?.replace("유산지포장지, ", "") + "${item.code_name}, "
            }else if(item.p_code_id == 1003) {
                order.options = order.options?.replace("2009, ", "")?.replace("2010, ", "")
                    ?.replace("2011, ", "") + "${item.code_id}, "
                order.optionsText =
                    order.optionsText?.replace("기본바구니, ", "")?.replace("중간바구니, ", "")
                        ?.replace("큰바구니, ", "") + "${item.code_name}, "
            }else if(item.p_code_id == 2016) {
                order.options = order.options?.replace("2017, ", "")?.replace("2018, ", "")
                    ?.replace("2019, ", "") + "${item.code_id}, "
                order.optionsText =
                    order.optionsText?.replace("기본화병, ", "")?.replace("스트라이프 화병, ", "")
                        ?.replace("없음, ", "") + "${item.code_name}, "
            }
        }

    }
}