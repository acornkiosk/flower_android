package com.flower_android.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.flower_android.databinding.FragmentAllBinding
import com.flower_android.list.ItemHandler
import com.flower_android.list.MenuAdapter
import com.flower_android.model.MenuItem
import com.flower_android.model.MenuProvider

class AllFragment : Fragment(), MenuProvider.Callback {
    private var binding: FragmentAllBinding? = null

    private val adapter by lazy { MenuAdapter(Handler()) }
    private val menuProvider = MenuProvider(this)
    private val menuList = mutableListOf<MenuItem>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentAllBinding.inflate(inflater, container, false).apply {
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
            menuProvider.getMenu(0)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun getMenuList(list: List<MenuItem>) {
        menuList.addAll(list)
        adapter.submitList(list)
    }

    class Handler : ItemHandler {
        override fun onClickItem(item: MenuItem) {
            Log.e("클릭", "$item")
        }
    }
}