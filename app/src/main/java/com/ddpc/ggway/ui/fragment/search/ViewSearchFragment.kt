package com.ddpc.ggway.ui.fragment.search

import com.ddpc.ggway.ui.MainView

/**
 * Created by diha- on 10.02.2018.
 */

interface ViewSearchFragment : MainView {
    fun refreshCategoryState(list: List<Any>)
}
