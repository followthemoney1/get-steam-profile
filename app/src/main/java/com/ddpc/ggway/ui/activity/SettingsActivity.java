package com.ddpc.ggway.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.widget.FrameLayout;

import com.ddpc.ggway.R;
import com.ddpc.ggway.ui.fragment.BottomSheetFragment;
import com.ddpc.ggway.ui.widget.BottomSheet;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dd.pc on 26.11.2017.
 */

public class SettingsActivity extends FragmentActivity {

    @BindView(R.id.actionUpCallback)
    BottomSheet bottomSheet;
    @BindView(R.id.containerLayout)
    FrameLayout container;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);

        addBottomFragment();
        setUpBottomSheet();
    }

    private void addBottomFragment(){
        getSupportFragmentManager().beginTransaction()
                .add(R.id.containerLayout, BottomSheetFragment.newInstance())
                .commit();
    }

    private void setUpBottomSheet(){
        bottomSheet.registerCallback(new BottomSheet.Callbacks() {
            @Override
            public void onSheetDismissed() {
                finishAfterTransition();
            }

            @Override
            public void onSheetPositionChanged(int sheetTop, boolean interacted) {
//                if (interacted && close.getVisibility() != View.VISIBLE) {
//                    close.setVisibility(View.VISIBLE);
//                    close.setAlpha(0f);
//                    close.animate()
//                            .alpha(1f)
//                            .setDuration(400L)
//                            .setInterpolator(getLinearOutSlowInInterpolator(PlayerSheet.this))
//                            .start();
//                }
//                if (sheetTop == 0) {
//                    showClose();
//                } else {
//                    showDown();
//                }
            }
        });
    }
}
