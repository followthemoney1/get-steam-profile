package com.ddpc.ggway.ui.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.animation.DynamicAnimation;
import android.support.animation.FlingAnimation;
import android.support.animation.SpringAnimation;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ddpc.ggway.ui.another.Gradients;

import butterknife.OnClick;

/**
 * Created by dd.pc on 03.12.2017.
 */

public class GradientFrameLayout extends FrameLayout implements View.OnClickListener {

    GradientDrawable background ;
    Drawable previousBackground;
    boolean clicked = false;

    public GradientFrameLayout(Context context) {
        super(context);
        setOnClickListener(this);
        background = Gradients.getRandomGradientDrawable(context);
    }

    public GradientFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnClickListener(this);
        background = Gradients.getRandomGradientDrawable(context);
    }

    public GradientFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOnClickListener(this);
        background = Gradients.getRandomGradientDrawable(context);
    }

    @Override
    public void onClick(View view) {
        if (!clicked) {
            previousBackground = view.getBackground();
            view.setBackground(background);
            clicked = true;
        }else {
            view.setBackground(previousBackground);
            clicked = false;
        }
    }

}
