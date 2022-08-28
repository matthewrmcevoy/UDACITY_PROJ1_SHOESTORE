package com.udacity.shoestore.screens.shoes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoedetailFragmentBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewModel

class ShoeDetailFragment : Fragment() {

    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: ShoedetailFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.shoedetail_fragment, container, false
        )
        binding.shoeSaveBttn.setOnClickListener {
            viewModel.saveShoe(binding.shoeNameEdit.text.toString(),binding.shoeSizeEdit.text.toString().toDouble(),binding.shoeBrandEdit.text.toString(),binding.shoeDescEdit.text.toString())
            findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }

        return binding.root
    }


    fun saveShoeDetails(name: String, size: Double, Company: String, Description: String ){

    }
}