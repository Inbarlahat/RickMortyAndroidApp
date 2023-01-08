package com.example.rickmortyv3.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.rickmortyv3.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import com.example.rickmortyv3.R
import com.google.android.material.tabs.TabLayout

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding  = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPager = binding.viewPager
        val tabLayout = binding.tabs

//        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
//        viewPager.adapter = adapter
        viewPager.adapter = ViewPagerAdapter()

//        TabLayoutMediator(tabLayout, viewPager, object : TabLayoutMediator.OnConfigureTabCallback {
//            override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
//                // Styling each tab here
//                tab.setText("Tab $position")
//            }
//        }).attach()

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when(position){
                0 -> { tab.text = getString(R.string.home_tab)}
                1 -> { tab.text = getString(R.string.all_characters_tab)}
                2 -> { tab.text = getString(R.string.create_tab)}
                3 -> { tab.text = getString(R.string.see_created_tab)}
            }
        }.attach()

    }
}