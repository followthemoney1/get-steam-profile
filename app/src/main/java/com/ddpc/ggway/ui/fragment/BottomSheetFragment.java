package com.ddpc.ggway.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ddpc.ggway.R;

/**
 * Created by dd.pc on 18.11.2017.
 */

public class BottomSheetFragment extends Fragment {

    public static BottomSheetFragment newInstance() {
        
        Bundle args = new Bundle();
        
        BottomSheetFragment fragment = new BottomSheetFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_bottom_sheet,container,false);
        
        return v;
    }
}
