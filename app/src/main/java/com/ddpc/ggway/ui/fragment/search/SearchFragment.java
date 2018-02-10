package com.ddpc.ggway.ui.fragment.search;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ddpc.ggway.R;
import com.ddpc.ggway.ui.widget.BackgroundMainAnimatedView;
import com.google.android.flexbox.FlexboxLayout;

import java.util.Iterator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.ddpc.ggway.utils.CategoryUtils.createOneCategory;

/**
 * Created by diha- on 10.02.2018.
 */

public class SearchFragment extends Fragment implements ViewSearchFragment {
    @BindView(R.id.flexboxLayout)
    FlexboxLayout flexboxLayout;
    @BindView(R.id.backgroundAnimatedView)
    BackgroundMainAnimatedView backgroundAnimatedView;

    PresenterSearchFragmentImpl presenter;

    public static SearchFragment newInstance() {
        Bundle args = new Bundle();
        SearchFragment fragment = new SearchFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_search,container,false);
        ButterKnife.bind(this,root);
        presenter = new PresenterSearchFragmentImpl(this);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.onLoadCategory();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
        backgroundAnimatedView.invalidate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
        backgroundAnimatedView.destroyAnimations();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void refreshCategoryState(List<Object> list) {
        flexboxLayout.removeAllViews();
        for (Iterator<Object> it = list.iterator(); it.hasNext(); ) {
            Object object = it.next();
            flexboxLayout.addView(createOneCategory(getContext(),object.toString()));
        }
    }
}
