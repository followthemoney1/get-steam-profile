package com.ddpc.ggway.ui.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.animation.DynamicAnimation;
import android.support.animation.FlingAnimation;
import android.support.animation.SpringAnimation;
import android.support.animation.SpringForce;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import static com.ddpc.ggway.utils.AnimationUtils.createSpringAnimation;

/**
 * Created by dd.pc on 03.12.2017.
 */

public class CardViewOnClickAnimation extends CardView implements View.OnClickListener {

    boolean clicked = false;

    public CardViewOnClickAnimation(Context context) {
        super(context);
        this.setOnClickListener(this);
    }

    public CardViewOnClickAnimation(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setOnClickListener(this);
    }

    public CardViewOnClickAnimation(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setOnClickListener(this);
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        this.callOnClick();
        return false;
    }

    @Override
    public void onClick(final View view) {
        if (!clicked) {
            SpringAnimation scaleXAnimation = createSpringAnimation(view, SpringAnimation.SCALE_X,
                    1f, SpringForce.STIFFNESS_LOW, SpringForce.DAMPING_RATIO_NO_BOUNCY);
            SpringAnimation scaleYAnimation = createSpringAnimation(view, SpringAnimation.SCALE_Y,
                    1f, SpringForce.STIFFNESS_LOW, SpringForce.DAMPING_RATIO_NO_BOUNCY);
            view.setScaleX(1.08f);
            view.setScaleY(1.08f);
            scaleXAnimation.start();
            scaleYAnimation.start();
            clicked = true;
        }else clicked = false;
    }
}
