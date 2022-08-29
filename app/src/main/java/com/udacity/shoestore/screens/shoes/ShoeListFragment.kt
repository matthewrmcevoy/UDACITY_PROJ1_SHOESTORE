package com.udacity.shoestore.screens.shoes

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeEntryBinding
import com.udacity.shoestore.databinding.ShoelistFragmentBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewModel
import kotlinx.android.synthetic.main.shoe_entry.*
import kotlinx.android.synthetic.main.shoelist_fragment.*
import timber.log.Timber

class ShoeListFragment : Fragment() {

    private val viewModel : ShoeViewModel by activityViewModels()
    private lateinit var binding: ShoelistFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: ShoelistFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.shoelist_fragment, container, false
        )
        binding.lifecycleOwner = this

        viewModel.shoesList.observe(viewLifecycleOwner, Observer{ shoeList->
            for(item in shoeList){
                val shoeItem = ShoeEntryBinding.inflate(layoutInflater)
                shoeItem.shoeData = item
                binding.linearShoeList.addView(shoeItem.root)
            }
        })

        /**viewModel.shoesList.observe(viewLifecycleOwner, Observer{
            sla ->
            for(shoe in sla) {
                binding.linearShoeList.addView(shoe_item)
            Timber.i("Adding a shoe through observer")
        }
        }) */

        binding.addShoeBttn.setOnClickListener{
        findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,
        requireView().findNavController())
                || super.onOptionsItemSelected(item)
        Timber.i("onOptionsItemSelected called")
    }
}
