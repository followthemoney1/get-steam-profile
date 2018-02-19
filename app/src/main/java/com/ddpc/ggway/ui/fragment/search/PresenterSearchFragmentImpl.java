package com.ddpc.ggway.ui.fragment.search;

import com.ddpc.ggway.data.FirebaseDataManager;

import java.util.List;

import static com.ddpc.ggway.data.FirebaseDataManager.loadCategory;

/**
 * Created by diha- on 10.02.2018.
 */

public class PresenterSearchFragmentImpl implements PresenterSearchFragment {
    ViewSearchFragment mainView;

    public PresenterSearchFragmentImpl(ViewSearchFragment root) {
        this.mainView = root;
    }


    @Override
    public void onResume() {
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onLoadCategory() {
        loadCategory(new FirebaseDataManager.CategoryCallback() {
            @Override
            public void onLoad(List<Object> list) {
                mainView.refreshCategoryState(list);
            }

            @Override
            public void onError() {
                mainView.showMessage("Error load category");
            }
        });
    }
}
