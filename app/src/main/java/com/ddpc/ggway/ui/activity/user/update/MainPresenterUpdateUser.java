package com.ddpc.ggway.ui.activity.user.update;

import android.view.View;

import com.ddpc.ggway.ui.activity.MainPresenter;

/**
 * Created by diha- on 03.02.2018.
 */

public interface MainPresenterUpdateUser extends MainPresenter {
    void onUpdateButtonClick(String userId);
    void onItemClicked(int position);
}
