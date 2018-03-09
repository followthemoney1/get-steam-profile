package com.ddpc.ggway.ui.fragment.user.create

import android.util.Log

import com.ddpc.ggway.data.steam.SteamUserGameDataLoader
import com.ddpc.ggway.data.steam.SteamUserProfileDataLoader
import com.ddpc.ggway.data.steam.UserData
import com.ddpc.ggway.data.steam.interfaces.SteamLoadCallback
import com.ddpc.ggway.data.steam.models.GameData
import com.ddpc.ggway.data.steam.models.SteamUser

/**
 * Created by diha- on 10.01.2018.
 */

class PresenterCreateUserImpl(internal var viewCreateUser: ViewCreateUser) : PresenterCreateUser {
    internal lateinit var steamUser: SteamUser;
    internal var userData:UserData = UserData(null, null)

    override fun onResume() {
        viewCreateUser.setTextChangeListener()
    }

    override fun onUpdateButtonClick(userId: String) {
        val steamUserProfileManager = SteamUserProfileDataLoader(steamLoadCallbackUserData)
        steamUserProfileManager.init(userId)
    }

    private fun loadGameInfo() {
        if (steamUser.steamID64!=null) {
            val steamUserGameDataLoader = SteamUserGameDataLoader(steamUser.steamID64, steamLoadCallbackGameData)
            steamUserGameDataLoader.init()
        }else{
            viewCreateUser.showMessage("Steam user id is wrong")
        }
    }

     var steamLoadCallbackUserData: SteamLoadCallback<SteamUser> = object : SteamLoadCallback<SteamUser> {
        override fun onSuccess(o: SteamUser) {
            steamUser = o
            userData.steamUser = steamUser
            loadGameInfo()
        }

        override fun onError(message: String) {
            viewCreateUser.showMessage(message)
        }
    }

     var steamLoadCallbackGameData: SteamLoadCallback<GameData> = object : SteamLoadCallback<GameData> {
        override fun onSuccess(o: GameData) {
            userData.gameData = o.response
            viewCreateUser.updateGameData(userData)
        }

        override fun onError(message: String) {
            Log.i("", "")
            viewCreateUser.showMessage(message)
        }
    }

    override fun onItemClicked(position: Int) {

    }

    override fun onDestroy() {

    }
}
