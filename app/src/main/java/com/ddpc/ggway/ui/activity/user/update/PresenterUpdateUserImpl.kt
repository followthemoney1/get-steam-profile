package com.ddpc.ggway.ui.activity.user.update

import android.util.Log

import com.ddpc.ggway.data.steam.SteamUserGameDataLoader
import com.ddpc.ggway.data.steam.SteamUserProfileDataLoader
import com.ddpc.ggway.data.steam.interfaces.SteamLoadCallback
import com.ddpc.ggway.data.steam.models.GameData
import com.ddpc.ggway.data.steam.models.SteamUser

/**
 * Created by diha- on 10.01.2018.
 */

class PresenterUpdateUserImpl(internal var mainView: ViewUpdateUser) : PresenterUpdateUser {
    internal lateinit var steamUser: SteamUser;

    internal var steamLoadCallbackUserData: SteamLoadCallback<SteamUser> = object : SteamLoadCallback<SteamUser> {
        override fun onSuccess(o: SteamUser) {
            steamUser = o
            loadGameInfo()
        }

        override fun onError(message: String) {
            mainView.showMessage(message)
        }
    }

    internal var steamLoadCallbackGameData: SteamLoadCallback<GameData> = object : SteamLoadCallback<GameData> {
        override fun onSuccess(o: GameData) {
            mainView.showMessage("Success")
        }

        override fun onError(message: String) {
            Log.i("", "")
            mainView.showMessage(message)
        }
    }


    override fun onResume() {
        mainView.setTextChangeListener()
    }

    override fun onUpdateButtonClick(userId: String) {
        val steamUserProfileManager = SteamUserProfileDataLoader(steamLoadCallbackUserData)
        steamUserProfileManager.init(userId)
    }

    private fun loadGameInfo() {
        val steamUserGameDataLoader = SteamUserGameDataLoader(steamUser.steamID64, steamLoadCallbackGameData)
        steamUserGameDataLoader.init()
    }


    override fun onItemClicked(position: Int) {

    }

    override fun onDestroy() {

    }
}
