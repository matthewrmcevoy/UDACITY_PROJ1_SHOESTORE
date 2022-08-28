package com.udacity.shoestore.screens.shoes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeEntryBinding

class ShoeItemFragment: Fragment() {

    private lateinit var binding: ShoeEntryBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: ShoeEntryBinding = DataBindingUtil.inflate(
            inflater, R.layout.shoe_entry, container, false)

        return binding.root
    }

}