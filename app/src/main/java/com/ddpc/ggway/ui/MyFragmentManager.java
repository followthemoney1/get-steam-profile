package com.ddpc.ggway.ui;

import android.app.Fragment;
import android.app.FragmentManager;

import com.ddpc.ggway.ui.fragment.search.SearchFragment;

/**
 * Created by diha- on 10.02.2018.
 */

public class MyFragmentManager {
    FragmentManager fr;
    int rootViewId;

    SearchFragment searchFragment;

    public MyFragmentManager(FragmentManager fr, int rootViewId) {
        this.fr = fr;
        this.rootViewId = rootViewId;
    }

    public void changeFragment(int position) {
        Fragment fragment = getFragmentByPosition(position);
        fr.beginTransaction()
                .replace(rootViewId, fragment)
                .commit();
    }

    public void onBackPressed(){
    }

    private Fragment getFragmentByPosition(int position) {
        switch (position) {
            case 0:
                if (searchFragment != null)
                    return searchFragment;
                else return searchFragment = SearchFragment.newInstance();

            default:
                return searchFragment = SearchFragment.newInstance();
        }
    }
}
