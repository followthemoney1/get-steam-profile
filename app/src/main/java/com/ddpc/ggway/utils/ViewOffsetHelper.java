package com.ddpc.ggway.utils;

import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.core.view.ViewCompat;
import android.view.View;

/**
 * Created by dd.pc on 12.11.2017.
 */

public class ViewOffsetHelper {

    public static final FloatPropertyCompat<ViewOffsetHelper> OFFSET_Y
            = new FloatPropertyCompat<ViewOffsetHelper>("offsetY") {
        @Override
        public float getValue(ViewOffsetHelper offsetHelper) {
            return offsetHelper.getTopAndBottomOffset();
        }

        @Override
        public void setValue(ViewOffsetHelper offsetHelper, float offset) {
            offsetHelper.setTopAndBottomOffset((int) offset);
        }
    };

    private final View mView;

    private int mLayoutTop;
    private int mLayoutLeft;
    private int mOffsetTop;
    private int mOffsetLeft;

    public ViewOffsetHelper(View view) {
        mView = view;
    }

    public void onViewLayout() {
        // Grab the intended top & left
        mLayoutTop = mView.getTop();
        mLayoutLeft = mView.getLeft();

        // And offset it as needed
        updateOffsets();
    }

    /**
     * Set the top and bottom offset for this {@link ViewOffsetHelper}'s view by
     * an absolute amount.
     *
     * @param absoluteOffset the offset in px.
     * @return true if the offset has changed
     */
    public boolean setTopAndBottomOffset(int absoluteOffset) {
        if (mOffsetTop != absoluteOffset) {
            mOffsetTop = absoluteOffset;
            updateOffsets();
            return true;
        }
        return false;
    }

    /**
     * Set the top and bottom offset for this {@link ViewOffsetHelper}'s view by
     * an relative amount.
     */
    public void offsetTopAndBottom(int relativeOffset) {
        mOffsetTop += relativeOffset;
        updateOffsets();
    }

    /**
     * Set the left and right offset for this {@link ViewOffsetHelper}'s view by
     * an absolute amount.
     *
     * @param absoluteOffset the offset in px.
     * @return true if the offset has changed
     */
    public boolean setLeftAndRightOffset(int absoluteOffset) {
        if (mOffsetLeft != absoluteOffset) {
            mOffsetLeft = absoluteOffset;
            updateOffsets();
            return true;
        }
        return false;
    }

    /**
     * Set the left and right offset for this {@link ViewOffsetHelper}'s view by
     * an relative amount.
     */
    public void offsetLeftAndRight(int relativeOffset) {
        mOffsetLeft += relativeOffset;
        updateOffsets();
    }

    public int getTopAndBottomOffset() {
        return mOffsetTop;
    }

    public int getLeftAndRightOffset() {
        return mOffsetLeft;
    }

    /**
     * Notify this helper that a change to the view's offsets has occurred outside of this class.
     */
    public void resyncOffsets() {
        mOffsetTop = mView.getTop() - mLayoutTop;
        mOffsetLeft = mView.getLeft() - mLayoutLeft;
    }

    private void updateOffsets() {
        ViewCompat.offsetTopAndBottom(mView, mOffsetTop - (mView.getTop() - mLayoutTop));
        ViewCompat.offsetLeftAndRight(mView, mOffsetLeft - (mView.getLeft() - mLayoutLeft));
    }

}