package com.furmannsoft.secutirystudy.view

import android.content.Context
import android.os.Bundle
import android.view.ViewGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.furmannsoft.secutirystudy.R
import com.furmannsoft.secutirystudy.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.bottomNavigationView.fitsSystemWindows = false


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        openFragment(HomeFragment())
        bottomNavigation()
    }

    private fun bottomNavigation(){
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeId -> {
                    openFragment(HomeFragment())
                    setTitle("")
                    true
                }
                R.id.transferId -> {
                    openFragment(TransferFragment())
                    setTitle("Transfer")
                    true
                }
                R.id.settingsId -> {
                    openFragment(SettingsFragment())
                    setTitle("Settings")
                    true
                }
                R.id.profileId -> {
                    openFragment(ProfileFragment())
                    setTitle("Profile")
                    true
                }
                else -> false
            }
        }
    }

    private fun openFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(binding.container.id, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}