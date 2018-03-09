package com.ddpc.ggway.ui.activity.user.update

import android.app.Activity
import android.os.Bundle
import android.widget.Toast

import com.ddpc.ggway.R

import butterknife.ButterKnife
import com.ddpc.ggway.data.steam.UserData
import com.ddpc.ggway.data.steam.models.GameData
import com.ddpc.ggway.data.steam.models.SteamUser
import com.ddpc.ggway.ui.fragment.user.change.ChangeUserProfileFragment
import com.ddpc.ggway.ui.fragment.user.create.CreateUserProfileFragment

/**
 * Created by diha- on 09.01.2018.
 */

class UserProfileActivity : Activity(), ViewUserProfile {
    lateinit var userData: UserData

    lateinit var createUserProfileFragment: CreateUserProfileFragment
    lateinit var changeUserProfileFragment: ChangeUserProfileFragment
    lateinit var presenter: PresenterUserProfileImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_user_profile)
        ButterKnife.bind(this)
        presenter = PresenterUserProfileImpl(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun addCreateUserProfileFragment() {
        createUserProfileFragment = CreateUserProfileFragment.newInstance()
        fragmentManager.beginTransaction()
                .replace(R.id.root, createUserProfileFragment)
                .addToBackStack("createUserProfileFragment")
                .commit()
    }

    override fun addUpdateUserProfileFragment() {
        changeUserProfileFragment = ChangeUserProfileFragment.newInstance(userData)
        fragmentManager.beginTransaction()
                .replace(R.id.root, changeUserProfileFragment)
                .addToBackStack("createUserProfileFragment")
                .commit()
    }

    override fun updateUserGameData(o: UserData) {
        userData = o
        addUpdateUserProfileFragment()
    }

    override fun showProgress() {

    }

    override fun hideProgress() {

    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onBackPressed() {
        if (fragmentManager.backStackEntryCount>1)
            fragmentManager.popBackStack()
        else
      finish()
    }
}
