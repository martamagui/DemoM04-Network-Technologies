package com.example.demom04netwroktechnologies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.demom04netwroktechnologies.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navController=findNavController(R.id.container)
        binding.bottomNav.setupWithNavController(navController)
//        binding.bottomNav.setOnItemReselectedListener {
//            // When es como un switch pero mucho más potente
//            when(it.itemId){
//                R.id.nav_tech->{
//                    Log.d("Nav", "Technology pulsado")
//                    findNavController(binding.container.id)
//                }
//                R.id.nav_image->{
//                    Log.d("Nav", "Image pulsado")
//                    findNavController(binding.container.id)
//                }
//            }
//
//            true
//        }
    }
}