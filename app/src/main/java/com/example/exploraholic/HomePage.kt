package com.example.exploraholic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import androidx.appcompat.widget.Toolbar
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomePage : AppCompatActivity() {
    private lateinit var viewPager2 : ViewPager2
    private lateinit var tabLayout : TabLayout
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar  //since type mismatched on line 20
    private lateinit var appPagerAdapter: AppPagerAdapter
    private val titles = arrayListOf("Hill Stations","Forts","Dams")  //for multiple list we require titles
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        toolbar = findViewById(R.id.toolbar1)
        tabLayout = findViewById(R.id.tablayout2)
        viewPager2 = findViewById(R.id.viewpager2)
        toolbar.title ="ExploraHolic"
        setSupportActionBar(toolbar)
        appPagerAdapter = AppPagerAdapter(this)    //we will create tab layout
        viewPager2.adapter = appPagerAdapter   //setting adapter
        TabLayoutMediator(tabLayout,viewPager2){
            tab,position->
            tab.text=titles[position]
        }.attach()
    }
    class AppPagerAdapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity){
        override fun getItemCount(): Int {
            return 3
        }

        override fun createFragment(position: Int): Fragment {
            return when(position){
                0->HillStations()
                1->Forts()
                2->Dams()

                else->HillStations()
            }
        }

    }
}