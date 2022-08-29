package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.navigateUp
import timber.log.Timber
import com.udacity.shoestore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var upNavigation = MutableLiveData<Boolean>()
    lateinit var destinationTitle : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        Timber.plant(Timber.DebugTree())

        //val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val navController =this.findNavController(R.id.myNavHostFragment)

        navController.addOnDestinationChangedListener { nc: NavController, nd: NavDestination, args: Bundle? ->
            Timber.i("$nc, $nd")
            destinationTitle = nd.label.toString()
            if(nd.label =="Shoe Inventory"){
                Timber.i("successfully caught Shoe Inventory navigation")
                upNavigation.value = false
            }else{
                upNavigation.value = true
            }
            Timber.i("show up arrow is ${upNavigation.value}")
        }

        upNavigation.observe(this, Observer{
            nv -> if(nv == true){
            //NavigationUI.setupActionBarWithNavController(this, navController)
            supportActionBar?.setDisplayShowHomeEnabled(true)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.title = destinationTitle
        }
            else{
            supportActionBar?.setDisplayShowHomeEnabled(false)
            supportActionBar?.setDisplayHomeAsUpEnabled(false)
            supportActionBar?.title = destinationTitle
                Timber.i("setHomeButtonEnabled called")
        }
        })


    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }
}
