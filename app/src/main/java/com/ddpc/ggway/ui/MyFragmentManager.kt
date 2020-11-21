package com.ddpc.ggway.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

import com.ddpc.ggway.ui.fragment.search.SearchFragment

/**
 * Created by diha- on 10.02.2018.
 */

class MyFragmentManager( var fr: FragmentManager,  var rootViewId: Int) {

    var searchFragment: SearchFragment? = null

    fun changeFragment(position: Int) {
        val fragment = getFragmentByPosition(position)
        fr.beginTransaction()
                .replace(rootViewId, fragment)
                .commit()
    }

    fun onBackPressed() {}

    private fun getFragmentByPosition(position: Int): Fragment {
        when (position) {
            0 -> {
                if (searchFragment==null)
                    searchFragment = SearchFragment.newInstance()

                return searchFragment!!
            }
            else -> return searchFragment!!
        }
    }
}
