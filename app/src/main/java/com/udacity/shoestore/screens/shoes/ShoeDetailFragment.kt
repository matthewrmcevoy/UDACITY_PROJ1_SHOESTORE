package com.udacity.shoestore.screens.shoes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoedetailFragmentBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: ShoedetailFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.shoedetail_fragment, container, false
        )
        binding.shoeSaveBttn.setOnClickListener {
        }

        return binding.root
    }


    fun saveShoeDetails(name: String, size: Double, Company: String, Description: String ){

    }
}