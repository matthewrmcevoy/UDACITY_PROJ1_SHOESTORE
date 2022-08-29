package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.navigateUp
import timber.log.Timber
import com.udacity.shoestore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
var bLock = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        Timber.plant(Timber.DebugTree())

        //val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val navController =this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController)

        navController.addOnDestinationChangedListener { nc: NavController, nd: NavDestination, args: Bundle? ->
            if (nd.id == R.layout.shoelist_fragment) {
                Timber.i("Navigation to shoeList")
                bLock= 1
            } else {
                Timber.i("Navigation somewhere anywhere")
                bLock = 0
            }
        }



    }
    override fun onSupportNavigateUp(): Boolean {
        if(bLock == 1){
            return false
        }else{
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }}
}
