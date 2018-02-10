package com.ddpc.ggway.ui.activity.home;

import android.content.Intent;

import com.ddpc.ggway.R;
import com.ddpc.ggway.data.UserManager;
import com.ddpc.ggway.ui.activity.user.update.UpdateUserProfileActivity;
import com.ddpc.ggway.utils.ViewUtils;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;
import java.util.List;

import static com.ddpc.ggway.utils.Constants.RC_SIGN_IN;

/**
 * Created by diha- on 10.02.2018.
 */

public class MainHomePresenterImpl implements MainHomePresenter {
    private MainHomeView mainView;

    private FirebaseAuth auth = FirebaseAuth.getInstance();

    private UserManager userPresenter = new UserManager();

    public MainHomePresenterImpl(MainHomeView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void onResume() {
        checkAuth();
    }

    @Override
    public void onDestroy() {

    }

    private void checkAuth(){
        if ( auth.getCurrentUser() == null){
            mainView.startSignInActivity();
        }else {
            checkIfUserExistsInDatabase();
        }
    }

    private void checkIfUserExistsInDatabase(){
        userPresenter.checkIfUserExistsInDatabase(auth.getCurrentUser(), new UserManager.ExistUserCallback() {
            @Override
            public void exists() {
                mainView.showMessage("User Exists");
            }

            @Override
            public void doesentExists() {
             mainView.showAlertDialogUpdateProfileInformation();
            }

            @Override
            public void error() {
                mainView.showMessage("User Exists Error");
            }
        });
    }
}
