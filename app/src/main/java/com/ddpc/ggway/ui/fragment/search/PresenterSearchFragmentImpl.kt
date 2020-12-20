package com.ddpc.ggway.ui.fragment.search

import com.ddpc.ggway.data.FirebaseDataManager

import com.ddpc.ggway.data.FirebaseDataManager.loadCategory

/**
 * Created by diha- on 10.02.2018.
 */

class PresenterSearchFragmentImpl(internal var mainView: ViewSearchFragment) : PresenterSearchFragment {

    override fun onResume() {}

    override fun onDestroy() {

    }

    override fun onLoadCategory() {
        loadCategory(object : FirebaseDataManager.CategoryCallback {
            override fun onLoad(list: List<Any>) {
                mainView.refreshCategoryState(list)
            }

            override fun onError() {
                mainView.showMessage("Error load category")
            }
        })
    }
}
