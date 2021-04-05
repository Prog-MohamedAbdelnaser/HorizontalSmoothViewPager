package com.softartch.horizontalviewpager.utils

import android.os.Build
import android.view.View
import androidx.viewpager.widget.ViewPager
import kotlin.math.abs

class CardsPagerTransformer(private val elevation: Float, private val raisingElevation: Float, private val unfocusedPagesScale:Float): ViewPager.PageTransformer {

    override fun transformPage(page: View, position: Float) {
        val absPosition = abs(position)
        if (absPosition >= 1) {
            page.elevation = elevation
            page.scaleY = unfocusedPagesScale
        } else {
            page.elevation = (1 - absPosition) * raisingElevation + elevation
            page.scaleY = (unfocusedPagesScale - 1) * absPosition + 1
        }
    }
}