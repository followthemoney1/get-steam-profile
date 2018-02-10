package com.ddpc.ggway.ui.activity.user.update;

import com.ddpc.ggway.ui.MainPresenter;

/**
 * Created by diha- on 03.02.2018.
 */

public interface PresenterUpdateUser extends MainPresenter {
    void onUpdateButtonClick(String userId);
    void onItemClicked(int position);
}
