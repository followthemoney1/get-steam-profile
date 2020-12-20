package com.ddpc.ggway.ui.widget

import android.content.Context
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.FlingAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.cardview.widget.CardView
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.Toast

import com.ddpc.ggway.ui.another.Gradients

import butterknife.OnClick

/**
 * Created by dd.pc on 03.12.2017.
 */

class GradientFrameLayout : FrameLayout, View.OnClickListener {

     var background: GradientDrawable
    var previousBackground: Drawable? = null
     var clicked = false

    constructor(context: Context) : super(context) {
        setOnClickListener(this)
        background = Gradients.getRandomGradientDrawable(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        setOnClickListener(this)
        background = Gradients.getRandomGradientDrawable(context)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        setOnClickListener(this)
        background = Gradients.getRandomGradientDrawable(context)
    }

    override fun onClick(view: View) {
        if (!clicked) {
            previousBackground = view.background
            view.background = background
            clicked = true
        } else {
            view.background = previousBackground
            clicked = false
        }
    }

}
