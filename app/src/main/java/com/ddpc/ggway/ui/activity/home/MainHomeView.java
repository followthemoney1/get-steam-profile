package com.ddpc.ggway.ui.activity.home;

import com.ddpc.ggway.ui.MainView;

/**
 * Created by diha- on 10.02.2018.
 */

public interface MainHomeView extends MainView {
    void changeFragment(int position);
    void startSignInActivity();
    void showAlertDialogUpdateProfileInformation();
}
