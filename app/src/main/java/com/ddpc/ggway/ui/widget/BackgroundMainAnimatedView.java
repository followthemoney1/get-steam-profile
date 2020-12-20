package com.ddpc.ggway.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.ddpc.ggway.R;

import java.util.Random;

/**
 * Created by diha- on 03.01.2018.
 */

public class BackgroundMainAnimatedView extends RelativeLayout {
    ImageView imgMainScreenBkgVerticalConsole;
    ImageView imgMainScreenBkgGamepad;
    ImageView imgMainScreenBkgHandGamepad;

    ValueAnimator imgMainScreenBkgVerticalConsoleAnimator;
    ValueAnimator imgMainScreenBkgGamepadAnimator;
    ValueAnimator imgMainScreenBkgHandGamepadAnimator;

    private final int MAX_HEIGHT = 80;
    private final int DELAY = 2000;

    public BackgroundMainAnimatedView(Context context) {
        super(context);
        init();
    }

    public BackgroundMainAnimatedView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BackgroundMainAnimatedView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    public BackgroundMainAnimatedView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_mainscreen_background, this);
        this.imgMainScreenBkgVerticalConsole = (ImageView) findViewById(R.id.imgMainScreenBkgVerticalConsole);
        this.imgMainScreenBkgGamepad = (ImageView) findViewById(R.id.imgMainScreenBkgGamepad);
        this.imgMainScreenBkgHandGamepad = (ImageView) findViewById(R.id.imgMainScreenBkgHandGamepad);
    }

    public void destroyAnimations() {
        if (imgMainScreenBkgVerticalConsoleAnimator != null) {
            clearAnimator(imgMainScreenBkgVerticalConsoleAnimator);
        }
        if (imgMainScreenBkgGamepadAnimator != null){
            clearAnimator(imgMainScreenBkgGamepadAnimator);
        }
        if (imgMainScreenBkgHandGamepadAnimator != null){
            clearAnimator(imgMainScreenBkgHandGamepadAnimator);
        }
    }

    private void clearAnimator(ValueAnimator animator) {
        animator.removeAllListeners();
        animator.end();
        animator.cancel();
    }

    @Override
    public void invalidate() {
        super.invalidate();
        setAnimation(imgMainScreenBkgVerticalConsole, imgMainScreenBkgVerticalConsole.getTranslationY(), true);
        setAnimation(imgMainScreenBkgGamepad, imgMainScreenBkgGamepad.getTranslationY(), true);
        setAnimation(imgMainScreenBkgHandGamepad, imgMainScreenBkgHandGamepad.getTranslationY(), true);
    }

    private void setAnimation(final ImageView view,  final float defaultY, final boolean goTop) {
        Random r = new Random();
        float randomYPosition = defaultY + 1 + (r.nextInt(MAX_HEIGHT));

        final float startPosition;
        final float endPosition;
        if (goTop) {
            startPosition = defaultY;
            endPosition = -randomYPosition;
        } else {
            startPosition = view.getTranslationY();
            endPosition = defaultY;
        }
        ValueAnimator animator = ValueAnimator.ofFloat(startPosition, endPosition);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.REVERSE);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float value = (float) valueAnimator.getAnimatedValue();
                    view.setTranslationY(value);
            }
        });
        animator.addListener(new AnimatorListenerAdapter()
        {
            @Override
            public void onAnimationEnd(Animator animation) {
//                setAnimation(view, defaultY, !goTop);
            }
        });
        animator.setDuration((long) (DELAY + endPosition));
        animator.start();
    }
}
