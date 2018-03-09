package com.ddpc.ggway.utils;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.CardView;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ddpc.ggway.R;
import com.ddpc.ggway.ui.widget.CardViewOnClickAnimation;
import com.ddpc.ggway.ui.widget.GradientFrameLayout;
import com.google.android.flexbox.FlexboxLayout;


/**
 * Created by dd.pc on 09.12.2017.
 */

public class CategoryUtils {

    public static CardView createOneCategory(Context context,String text){
        if (context==null) return null;
        Resources res = context.getResources();
        int spacing_micro =(int) res.getDimension(R.dimen.spacing_micro);
        int spacing_medium =(int) res.getDimension(R.dimen.spacing_medium);
        int padding_normal =(int) res.getDimension(R.dimen.padding_normal);

        TextView textView = new TextView(context);
        textView.setTextColor(res.getColor(R.color.background_color));
        textView.setTextSize(14);
        textView.setLetterSpacing(-0.04f);
        textView.setPadding(padding_normal,spacing_medium,padding_normal,spacing_medium);
        textView.setAllCaps(true);
        textView.setText(text);

        GradientFrameLayout gradientFrameLayout = new GradientFrameLayout(context);
      //  gradientFrameLayout.setAlpha(0.8f);

        CardViewOnClickAnimation cardViewOnClickAnimation = new CardViewOnClickAnimation(context);
        cardViewOnClickAnimation.setElevation(6);
        cardViewOnClickAnimation.setRadius(padding_normal);
        FlexboxLayout.LayoutParams cardParams =  new FlexboxLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        cardParams.setMargins(spacing_medium,10,0,10);
        cardViewOnClickAnimation.setLayoutParams(cardParams);

        gradientFrameLayout.addView(textView);
        cardViewOnClickAnimation.addView(gradientFrameLayout);

        return cardViewOnClickAnimation;
    }
}
