package com.ddpc.ggway.ui.fragment.user.create

import com.ddpc.ggway.data.steam.UserData
import com.ddpc.ggway.data.steam.models.GameData
import com.ddpc.ggway.data.steam.models.SteamUser
import com.ddpc.ggway.ui.MainView

/**
 * Created by diha- on 03.02.2018.
 */

interface ViewCreateUser : MainView {
    fun setOnItemClick()
    fun setTextChangeListener()
    fun updateGameData(o: UserData)
}
