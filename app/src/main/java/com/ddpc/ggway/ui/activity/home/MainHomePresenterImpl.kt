package com.ddpc.ggway.ui.activity.home

import android.content.Intent

import com.ddpc.ggway.R
import com.ddpc.ggway.data.UserManager
import com.ddpc.ggway.ui.activity.user.update.UpdateUserProfileActivity
import com.ddpc.ggway.utils.ViewUtils
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth

import java.util.Arrays

import com.ddpc.ggway.utils.Constants.RC_SIGN_IN

/**
 * Created by diha- on 10.02.2018.
 */

class MainHomePresenterImpl(private val mainView: MainHomeView) : MainHomePresenter {

    val auth = FirebaseAuth.getInstance()

    val userPresenter = UserManager()

    override fun onResume() {
        checkAuth()
    }

    override fun onDestroy() {

    }

    private fun checkAuth() {
        if (auth.currentUser == null) {
            mainView.startSignInActivity()
        } else {
            checkIfUserExistsInDatabase()
        }
    }

    private fun checkIfUserExistsInDatabase() {
        userPresenter.checkIfUserExistsInDatabase(auth.currentUser!!, object : UserManager.ExistUserCallback {
            override fun exists() {
                mainView.showMessage("User Exists")
            }

            override fun doesentExists() {
                mainView.showAlertDialogUpdateProfileInformation()
            }

            override fun error() {
                mainView.showMessage("User Exists Error")
            }
        })
    }
}
