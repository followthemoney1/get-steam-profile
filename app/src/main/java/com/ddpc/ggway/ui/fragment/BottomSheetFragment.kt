package com.ddpc.ggway.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.ddpc.ggway.R

/**
 * Created by dd.pc on 18.11.2017.
 */

class BottomSheetFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_bottom_sheet, container, false)
    }

    companion object {

        fun newInstance(): BottomSheetFragment {

            val args = Bundle()

            val fragment = BottomSheetFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
