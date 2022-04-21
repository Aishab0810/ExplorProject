package com.example.exploraholic.Dashboard

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.exploraholic.Dams
import com.example.exploraholic.Fragments.Forts
import com.example.exploraholic.HillStations
import com.example.exploraholic.MainScreens.LoginScreen
import com.example.exploraholic.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomePage : AppCompatActivity() {
    private lateinit var viewPager2: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar  //since type mismatched on line 20
    private lateinit var appPagerAdapter: AppPagerAdapter
    private lateinit var imageView: ImageView
    private lateinit var homeimg1: ImageView

    private val titles = arrayListOf("Hillstations ", "Forts ", "Dams ")  //for multiple list we require titles
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

//        val navController = findNavController(R.id.container_fragment)
//        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
//
//        bottomNavigationView.setupWithNavController(navController)

        toolbar = findViewById(R.id.toolbar1)
        tabLayout = findViewById(R.id.tablayout2)
        viewPager2 = findViewById(R.id.viewpager2)
//        imageView = findViewById(R.id.mapimg)
        toolbar.title = "Exploraholic"
        setSupportActionBar(toolbar)
        appPagerAdapter = AppPagerAdapter(this)    //we will create tab layout
        viewPager2.adapter = appPagerAdapter   //setting adapter
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            tab.text = titles[position]
        }.attach()

        val image1 = findViewById(R.id.log_out) as ImageView
        // set on-click listener
        image1.setOnClickListener {
            startActivity(Intent(this, LoginScreen::class.java))
            Toast.makeText(this@HomePage, "Logout", Toast.LENGTH_SHORT).show()
        }

        val homeimg1 = findViewById(R.id.homeimg) as ImageView
        // set on-click listener
        homeimg1.setOnClickListener {
            startActivity(Intent(this, Dashboard::class.java))
            Toast.makeText(this@HomePage, "HomePage", Toast.LENGTH_SHORT).show()
        }
    }





    class AppPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int {
            return 3
        }

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> HillStations()
                1 -> Forts()
                2 -> Dams()

                else -> HillStations()
            }
        }

    }
}
