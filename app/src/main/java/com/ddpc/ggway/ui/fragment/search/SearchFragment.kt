package com.ddpc.ggway.ui.fragment.search

import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.ddpc.ggway.R
import com.ddpc.ggway.ui.widget.BackgroundMainAnimatedView
import com.google.android.flexbox.FlexboxLayout

import butterknife.BindView
import butterknife.ButterKnife

import com.ddpc.ggway.utils.CategoryUtils.createOneCategory

/**
 * Created by diha- on 10.02.2018.
 */

class SearchFragment : Fragment(),ViewSearchFragment {
    @BindView(R.id.flexboxLayout)
    lateinit var flexboxLayout: FlexboxLayout
    @BindView(R.id.backgroundAnimatedView)
    lateinit var backgroundAnimatedView: BackgroundMainAnimatedView

    lateinit var presenter: PresenterSearchFragmentImpl

    companion object {
        fun newInstance(): SearchFragment {
            val args = Bundle()
            val fragment = SearchFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val root = inflater!!.inflate(R.layout.fragment_search, container, false)
        ButterKnife.bind(this, root)
        presenter = PresenterSearchFragmentImpl(this)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onLoadCategory()
    }

    override fun onResume() {
        super.onResume()
       presenter.onResume()
       backgroundAnimatedView.invalidate()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
        backgroundAnimatedView.destroyAnimations()
    }

    override fun showProgress() {

    }

    override fun hideProgress() {

    }

    override fun showMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun refreshCategoryState(list: List<Any>) {
        flexboxLayout.removeAllViews()
        val it = list.iterator()
        while (it.hasNext()) {
            val temp = it.next()
            flexboxLayout.addView(createOneCategory(context, temp.toString())!!)
        }
    }
}
