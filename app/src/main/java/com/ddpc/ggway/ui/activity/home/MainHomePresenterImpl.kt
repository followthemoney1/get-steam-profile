package com.ddpc.ggway.ui.activity.home

import com.ddpc.ggway.data.UserManager
import com.google.firebase.auth.FirebaseAuth

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
