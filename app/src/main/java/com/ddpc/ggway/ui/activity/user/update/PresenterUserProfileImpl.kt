package com.ddpc.ggway.ui.activity.user.update

import com.ddpc.ggway.data.UserManager

/**
 * Created by diha- on 01.03.2018.
 */
class PresenterUserProfileImpl(var viewUserProfile: ViewUserProfile):PresenterUserProfile {

    override fun onResume() {
        checkIfUserExistsInDatabase();
    }

    override fun onDestroy() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun checkIfUserExistsInDatabase() {
        val userManager = UserManager()
        userManager.checkIfUserExistsInDatabase(UserManager.currentUser!!, object : UserManager.ExistUserCallback {
            override fun exists() {
                viewUserProfile.addUpdateUserProfileFragment()
            }

            override fun doesentExists() {
                viewUserProfile.addCreateUserProfileFragment()
            }

            override fun error() {
                viewUserProfile.showMessage("Error firebase")
            }
        })
    }
}