package com.ddpc.ggway.ui.widget

import android.animation.ValueAnimator
import android.content.Context
import android.support.animation.DynamicAnimation
import android.support.animation.FlingAnimation
import android.support.animation.SpringAnimation
import android.support.animation.SpringForce
import android.support.v7.widget.CardView
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.Toast

import com.ddpc.ggway.utils.AnimationUtils.createSpringAnimation

/**
 * Created by dd.pc on 03.12.2017.
 */

class CardViewOnClickAnimation : CardView, View.OnClickListener {

    internal var clicked = false

    constructor(context: Context) : super(context) {
        this.setOnClickListener(this)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        this.setOnClickListener(this)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        this.setOnClickListener(this)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        this.callOnClick()
        return false
    }

    override fun onClick(view: View) {
        if (!clicked) {
            val scaleXAnimation = createSpringAnimation(view, SpringAnimation.SCALE_X,
                    1f, SpringForce.STIFFNESS_LOW, SpringForce.DAMPING_RATIO_NO_BOUNCY)
            val scaleYAnimation = createSpringAnimation(view, SpringAnimation.SCALE_Y,
                    1f, SpringForce.STIFFNESS_LOW, SpringForce.DAMPING_RATIO_NO_BOUNCY)
            view.scaleX = 1.08f
            view.scaleY = 1.08f
            scaleXAnimation.start()
            scaleYAnimation.start()
            clicked = true
        } else
            clicked = false
    }
}
