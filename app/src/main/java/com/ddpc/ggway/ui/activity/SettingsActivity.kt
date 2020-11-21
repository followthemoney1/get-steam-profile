package com.ddpc.ggway.ui.activity

import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.FragmentActivity
import kotlinx.android.synthetic.main.activity_settings.*
import com.ddpc.ggway.R
import com.ddpc.ggway.ui.fragment.BottomSheetFragment
import com.ddpc.ggway.ui.fragment.BottomSheetFragment.Companion.newInstance
import com.ddpc.ggway.ui.widget.BottomSheet
import kotlinx.android.synthetic.main.activity_settings.*

/**
 * Created by dd.pc on 26.11.2017.
 */
class SettingsActivity : FragmentActivity() {

    lateinit var bottomSheetFragment: BottomSheetFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        addBottomFragment()
        setUpBottomSheet()
    }

    private fun addBottomFragment() {
        bottomSheetFragment = newInstance()
        supportFragmentManager.beginTransaction()
                .add(R.id.containerLayout, bottomSheetFragment)
                .commit()
    }

    private fun setUpBottomSheet() {
//        bottomSheetFragment.bottomSheet.registerCallback(object : BottomSheet.Callbacks() {
//            override fun onSheetDismissed() {
//                finishAfterTransition()
//            }
//
//            override fun onSheetPositionChanged(sheetTop: Int, interacted: Boolean) {
////                if (interacted && close.getVisibility() != View.VISIBLE) {
////                    close.setVisibility(View.VISIBLE);
////                    close.setAlpha(0f);
////                    close.animate()
////                            .alpha(1f)
////                            .setDuration(400L)
////                            .setInterpolator(getLinearOutSlowInInterpolator(PlayerSheet.this))
////                            .start();
////                }
////                if (sheetTop == 0) {
////                    showClose();
////                } else {
////                    showDown();
////                }
//            }
//        })
    }
}