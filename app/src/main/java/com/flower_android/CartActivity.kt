package com.flower_android

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.flower_android.databinding.ActivityCartBinding
import com.flower_android.list.cart.CartAdapter
import com.flower_android.list.cart.CartItemHandler
import com.flower_android.model.OrderItem
import com.flower_android.model.OrderProvider
import com.flower_android.util.PreferenceUtil

class CartActivity : AppCompatActivity(), OrderProvider.Callback {
    private lateinit var binding: ActivityCartBinding

    private val adapter by lazy { CartAdapter(Handler()) }
    private var list = mutableListOf<OrderItem>()
    private val orderProvider = OrderProvider(this)
    private lateinit var preferenceUtil: PreferenceUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.view = this
        preferenceUtil = PreferenceUtil(this)
        initView()

    }

    private fun initView() {
        list = PreferenceUtil(this).getAllOrders()
        binding.apply {
            recyclerView.adapter = adapter
            adapter.submitList(list)
        }
        orderProvider.getOrderId()
    }

    fun goHome() {
        finish()
    }

    fun order() {
        list.forEach {
            orderProvider.order(it)
        }
        Toast.makeText(this, "주문이 접수 되었습니다!", Toast.LENGTH_SHORT).show()
        preferenceUtil.refresh()
        finish()
    }

    inner class Handler : CartItemHandler {
        override fun minus(count: Int, id: Int) {
            list.map {
                if (it.id == id) {
                    it.menu_count = count
                    preferenceUtil.deleteOrder(it.id!!)
                    preferenceUtil.setOrder(it.id.toString(), it)
                }
                return@map it
            }
        }

        override fun plus(count: Int, id: Int) {
            list.map {
                if (it.id == id) {
                    it.menu_count = count
                    preferenceUtil.deleteOrder(it.id!!)
                    preferenceUtil.setOrder(it.id.toString(), it)
                }
                return@map it
            }
        }

        override fun delete(item: OrderItem) {
            list.remove(item)
            preferenceUtil.deleteOrder(item.id!!)
            adapter.submitList(ArrayList(list))
            adapter.notifyDataSetChanged()
        }

    }

    override fun order(isSuccess: Boolean) {
        Log.e("주문 성공 여부", isSuccess.toString())
    }

    override fun getOrderId(order_id: Int) {
        list.map {
            it.order_id = order_id
        }
    }
}