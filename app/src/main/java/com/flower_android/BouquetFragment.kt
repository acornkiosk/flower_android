package com.flower_android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.flower_android.databinding.FragmentBouquetBinding

class BouquetFragment : Fragment() {
    private var binding: FragmentBouquetBinding? = null

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