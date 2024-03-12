package com.flower_android

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.flower_android.databinding.FragmentBasketBinding
import com.flower_android.list.ItemHandler
import com.flower_android.list.MenuAdapter
import com.flower_android.model.MenuItem
import com.flower_android.model.MenuProvider

class BasketFragment : Fragment(), MenuProvider.Callback {
    private var binding: FragmentBasketBinding? = null

    private val adapter by lazy { MenuAdapter(Handler()) }
    private val menuProvider = MenuProvider(this)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentBasketBinding.inflate(inflater, container, false).apply {
            binding = this
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            recyclerView.adapter = adapter
        }
    }

    override fun onResume() {
        super.onResume()
        binding?.apply {
            menuProvider.getMenu(1003)
        }
    }
    override fun getMenuList(list: List<MenuItem>) {
        adapter.submitList(list)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    class Handler : ItemHandler {
        override fun onClickItem(item: MenuItem) {
            Log.e("클릭", "$item")
        }
    }
}