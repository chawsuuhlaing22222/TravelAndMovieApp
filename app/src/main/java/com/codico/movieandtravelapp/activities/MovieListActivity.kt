package com.codico.movieandtravelapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.codico.movieandtravelapp.R
import com.codico.movieandtravelapp.adapters.HomeVPAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_movie_list.*

class MovieListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)
        setUpViewPager()
        setUpTablayout()

    }

    private fun setUpTablayout() {
        //tablayout setup
        TabLayoutMediator(tablayoutHome, vpHome) { tab, position ->

            when (position) {

                0 -> tab.text = "Movies "
                1 -> tab.text = "Events "
                2->tab.text = "Plays "
                3->tab.text = "Sports "
                4->tab.text = "Activities "

            }
        }.attach()
    }

    private fun setUpViewPager() {
        //viewpager setup
        val homeAdapter =  HomeVPAdapter(this)
        vpHome.adapter = homeAdapter
    }
}