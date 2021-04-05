package com.softartch.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.softartch.horizontalviewpager.viewpager.HorizontalViewPager

class MainActivity : AppCompatActivity() {

    private var currentPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter =   ExPagerAdapter(
            listOf(
                "( ͡°( ͡° ͜ʖ( ͡° ͜ʖ ͡°)ʖ ͡°) ͡°)",
                ",♥‿♥",
                "༼ʘ̚ل͜ʘ̚༽"
            ), this
        )
      val viewPager =   findViewById<HorizontalViewPager>(R.id.hviewPager)
        viewPager.initSwipingAnimation()
        viewPager.adapter =  adapter

    }



}

