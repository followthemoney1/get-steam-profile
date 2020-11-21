package com.ddpc.ggway.ui.another;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import androidx.core.content.ContextCompat;
import android.util.Pair;

import com.ddpc.ggway.R;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by dd.pc on 03.12.2017.
 */

public class Gradients {
    private static int gradient_teal_start = R.color.gradient_teal_start;
    private static int gradient_teal_end = R.color.gradient_teal_end;

    private static int gradient_startfall_start = R.color.gradient_startfall_start;
    private static int gradient_startfall_end = R.color.gradient_startfall_end;

    private static int gradient_forget_start = R.color.gradient_forget_start;
    private static int gradient_forget_end = R.color.gradient_forget_end;

    private static int gradient_cream_start = R.color.gradient_cream_start;
    private static int gradient_cream_ent = R.color.gradient_cream_ent;

    private static int gradient_virgin_start = R.color.gradient_virgin_start;
    private static int gradient_virgin_end = R.color.gradient_virgin_end;

    private static int gradient_dirtyfrog_start = R.color.gradient_dirtyfrog_start;
    private static int gradient_dirtyfrog_end = R.color.gradient_dirtyfrog_end;

    private static int gradient_reef_start = R.color.gradient_reef_start;
    private static int gradient_reef_end = R.color.gradient_reef_end;

    private static int gradient_candy_start = R.color.gradient_candy_start;
    private static int gradient_candy_end = R.color.gradient_candy_end;

    private static int gradient_autumn_start = R.color.gradient_autumn_start;
    private static int gradient_autumn_end = R.color.gradient_autumn_end;

    private static int gradient_kyoto_start = R.color.gradient_kyoto_start;
    private static int gradient_kyoto_end = R.color.gradient_kyoto_end;

    private static int gradient_memory_start = R.color.gradient_memory_start;
    private static int gradient_memory_end = R.color.gradient_memory_end;

    private static List<Pair<Integer, Integer>> gradients = Arrays.asList(
            new Pair<Integer, Integer>(gradient_teal_start, gradient_teal_end),
            new Pair<Integer, Integer>(gradient_startfall_start, gradient_startfall_end),
            new Pair<Integer, Integer>(gradient_forget_start, gradient_forget_end),
            new Pair<Integer, Integer>(gradient_cream_start, gradient_cream_ent),
            new Pair<Integer, Integer>(gradient_virgin_start, gradient_virgin_end),
            new Pair<Integer, Integer>(gradient_dirtyfrog_start, gradient_dirtyfrog_end),
            new Pair<Integer, Integer>(gradient_reef_start, gradient_reef_end),
            new Pair<Integer, Integer>(gradient_candy_start, gradient_candy_end),
            new Pair<Integer, Integer>(gradient_autumn_start, gradient_autumn_end),
            new Pair<Integer, Integer>(gradient_kyoto_start, gradient_kyoto_end),
            new Pair<Integer, Integer>(gradient_memory_start, gradient_memory_end));

    public static GradientDrawable getRandomGradientDrawable(Context context) {
        Pair<Integer,Integer> temp = gradients.get(getRandomNumber());
        return getRandomGradient(context,temp.first,temp.second);
    }

    private static GradientDrawable getRandomGradient( Context context,int firstColor, int secondColor) {

        int[] colors = {Color.parseColor("#"+Integer.toHexString(ContextCompat.getColor(context, firstColor))),
                Color.parseColor("#"+Integer.toHexString(ContextCompat.getColor(context, secondColor)))};

        //create a new gradient color
        GradientDrawable gd = new GradientDrawable(
                GradientDrawable.Orientation.LEFT_RIGHT, colors);

        gd.setCornerRadius(0f);

        return gd;
    }

    private static int getRandomNumber(){
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(gradients.size());
        return randomInt;
    }
}
