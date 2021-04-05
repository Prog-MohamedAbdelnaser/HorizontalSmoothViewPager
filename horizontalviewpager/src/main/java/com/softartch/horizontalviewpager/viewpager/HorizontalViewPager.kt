package com.softartch.horizontalviewpager.viewpager

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import androidx.viewpager.widget.ViewPager
import com.softartch.horizontalviewpager.R
import com.softartch.horizontalviewpager.utils.CardsPagerTransformer
import com.softartch.horizontalviewpager.utils.FixedSpeedScroller
import java.lang.reflect.Field

class HorizontalViewPager(context: Context, attrs: AttributeSet?) : ViewPager(context, attrs) {

    private var baseElevation = 0f
    private var raisingElevation = 1f
    private var smallerScale = 0.5f

    constructor(context: Context) : this(context, null)


    init {
        initView(context, attrs)
        initViewPager()
    }

    private fun initView(context: Context, attrs: AttributeSet?) {
        if (attrs != null) {
            val a = context.obtainStyledAttributes(attrs, R.styleable.HorizontalViewPager)
            smallerScale = a.getFloat(R.styleable.HorizontalViewPager_pagesScale, 0.6f)
            raisingElevation = a.getFloat(R.styleable.HorizontalViewPager_raisingElevation, 1f)
            baseElevation = a.getFloat(R.styleable.HorizontalViewPager_baseElevation, 0f)
            a.recycle()
        }
    }
    fun setOtherPagersScale(scale:Float): HorizontalViewPager {
        smallerScale = scale
        return this
    }

    fun setBaseElevation(elevation:Float): HorizontalViewPager {
        baseElevation = elevation
        return this

    }

    fun setRaisingElevation(elevation: Float): HorizontalViewPager {
        raisingElevation = elevation
        return this

    }

    fun initSwipingAnimation(){
        addOnPageChangeListener(object :OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                manageWidgetsOnSwipe(position)

            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })
    }

    private var currentPosition = 0
    private fun manageWidgetsOnSwipe(pos: Int) {
        val animH = intArrayOf(R.anim.slide_in_right, R.anim.slide_out_left)
        val animV = intArrayOf(R.anim.slide_in_top, R.anim.slide_out_bottom)
        val left2right: Boolean = pos < currentPosition
        if (left2right) {
            animH[0] = R.anim.slide_in_left
            animH[1] = R.anim.slide_out_right
            animV[0] = R.anim.slide_in_bottom
            animV[1] = R.anim.slide_out_top
        }else{
            animH[0] = R.anim.slide_out_right
            animH[1] = R.anim.slide_in_left
            animV[0] = R.anim.slide_in_bottom
            animV[1] = R.anim.slide_out_top
        }
        currentPosition = pos
    }

    fun build(){
        initViewPager()
    }
    private fun initViewPager() {
        try {
            val viewpager: Class<*> = ViewPager::class.java
            val mScroller: Field = viewpager.getDeclaredField("mScroller")
            mScroller.isAccessible = true
            val scroller = FixedSpeedScroller(context)
            mScroller[this] = scroller
            transformViewPager()
            clipToPadding = false
        } catch (e: NoSuchFieldException) {
        } catch (e: IllegalArgumentException) {
        } catch (e: IllegalAccessException) {
        }
    }


    private fun transformViewPager() {
        val r = resources
        val partialWidth =
            TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16f, r.displayMetrics).toInt()
        val pageMargin =
            TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15f, r.displayMetrics).toInt()
        val viewPagerPadding = partialWidth + pageMargin
        setPageMargin(pageMargin)
        setPadding(viewPagerPadding, 0, viewPagerPadding, 0)
        setPageTransformer(
            false,
            CardsPagerTransformer(
                baseElevation,
                raisingElevation,
                smallerScale
            )
        )
    }
}