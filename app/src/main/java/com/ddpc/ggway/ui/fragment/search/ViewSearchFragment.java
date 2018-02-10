package com.ddpc.ggway.ui.fragment.search;

import com.ddpc.ggway.ui.MainView;

import java.util.List;

/**
 * Created by diha- on 10.02.2018.
 */

public interface ViewSearchFragment extends MainView {
    void refreshCategoryState(List<Object> list);
}
