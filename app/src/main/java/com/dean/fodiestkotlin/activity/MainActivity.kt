package com.dean.fodiestkotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.dean.fodiestkotlin.Fragment.FavoriteFragment
import com.dean.fodiestkotlin.Fragment.HomeFragment
import com.dean.fodiestkotlin.Fragment.LocationFragment
import com.dean.fodiestkotlin.Fragment.ProfileFragment
import com.dean.fodiestkotlin.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    val homeFragment = HomeFragment()
                    addFragment(homeFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_location -> {
                    val locationFragment = LocationFragment()
                    addFragment(locationFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_favorite -> {
                    val favoriteFragment = FavoriteFragment()
                    addFragment(favoriteFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_profile -> {
                    val profileFragment = ProfileFragment()
                    addFragment(profileFragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fm_main_container, fragment, fragment::class.java.simpleName)
            .addToBackStack(null).commit()
    }
    val defaultMainView = HomeFragment.defaultFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        nav_main.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        addFragment(defaultMainView)
    }
}
