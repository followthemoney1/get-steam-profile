package com.ddpc.ggway.ui.activity.user.update

import com.ddpc.ggway.data.steam.UserData
import com.ddpc.ggway.ui.MainView

/**
 * Created by diha- on 01.03.2018.
 */
interface ViewUserProfile:MainView {
    fun addCreateUserProfileFragment()
    fun addUpdateUserProfileFragment()
    fun updateUserGameData(o: UserData)
}