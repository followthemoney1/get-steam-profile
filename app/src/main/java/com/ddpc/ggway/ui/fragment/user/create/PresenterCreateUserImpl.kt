package com.ddpc.ggway.ui.fragment.user.create

import android.util.Log

import com.ddpc.ggway.data.steam.SteamUserGameDataLoader
import com.ddpc.ggway.data.steam.SteamUserProfileDataLoader
import com.ddpc.ggway.data.steam.interfaces.SteamLoadCallback
import com.ddpc.ggway.data.steam.models.GameData
import com.ddpc.ggway.data.steam.models.SteamUser

/**
 * Created by diha- on 10.01.2018.
 */

class PresenterCreateUserImpl(internal var mainView: ViewCreateUser) : PresenterCreateUser {
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
        if (steamUser.steamID64!=null) {
            val steamUserGameDataLoader = SteamUserGameDataLoader(steamUser.steamID64, steamLoadCallbackGameData)
            steamUserGameDataLoader.init()
        }else{
            mainView.showMessage("Steam user id is wrong")
        }
    }


    override fun onItemClicked(position: Int) {

    }

    override fun onDestroy() {

    }
}
