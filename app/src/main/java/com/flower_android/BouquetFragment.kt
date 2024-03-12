package com.flower_android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.flower_android.databinding.FragmentBouquetBinding
import com.flower_android.list.ItemHandler
import com.flower_android.list.ListAdapter

class BouquetFragment : Fragment() {
    private var binding: FragmentBouquetBinding? = null

    private val adapter by lazy { ListAdapter(ItemHandler()) }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentBouquetBinding.inflate(inflater, container, false).apply {
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

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}