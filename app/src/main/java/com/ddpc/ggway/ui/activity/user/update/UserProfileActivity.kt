package com.ddpc.ggway.ui.activity.user.update

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentActivity

import com.ddpc.ggway.R

import com.ddpc.ggway.data.steam.UserData
import com.ddpc.ggway.data.steam.models.GameData
import com.ddpc.ggway.data.steam.models.SteamUser
import com.ddpc.ggway.ui.fragment.user.change.ChangeUserProfileFragment
import com.ddpc.ggway.ui.fragment.user.create.CreateUserProfileFragment
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

/**
 * Created by diha- on 09.01.2018.
 */

class UserProfileActivity : FragmentActivity(), ViewUserProfile {
    lateinit var userData: UserData

    lateinit var createUserProfileFragment: CreateUserProfileFragment
    lateinit var changeUserProfileFragment: ChangeUserProfileFragment
    lateinit var presenter: PresenterUserProfileImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_user_profile)
        presenter = PresenterUserProfileImpl(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    protected override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    override fun addCreateUserProfileFragment() {
        createUserProfileFragment = CreateUserProfileFragment.newInstance()

        supportFragmentManager.beginTransaction()
                .replace(R.id.root, createUserProfileFragment)
                .addToBackStack("createUserProfileFragment")
                .commit()
    }

    override fun addUpdateUserProfileFragment() {
        changeUserProfileFragment = ChangeUserProfileFragment.newInstance(userData)
        supportFragmentManager.beginTransaction()
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
