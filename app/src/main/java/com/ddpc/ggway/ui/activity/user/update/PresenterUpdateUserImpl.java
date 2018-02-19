package com.ddpc.ggway.ui.activity.user.update;

import android.util.Log;

import com.ddpc.ggway.data.steam.SteamUserGameDataLoader;
import com.ddpc.ggway.data.steam.SteamUserProfileDataLoader;
import com.ddpc.ggway.data.steam.interfaces.SteamLoadCallback;
import com.ddpc.ggway.data.steam.models.GameData;
import com.ddpc.ggway.data.steam.models.SteamUser;

/**
 * Created by diha- on 10.01.2018.
 */

public class PresenterUpdateUserImpl implements PresenterUpdateUser {
    SteamUser steamUser;

    ViewUpdateUser mainView;

    public PresenterUpdateUserImpl(ViewUpdateUser mainView) {
        this.mainView = mainView;
    }


    @Override
    public void onResume() {
        mainView.setTextChangeListener();
    }

    @Override
    public void onUpdateButtonClick(String userId) {
        SteamUserProfileDataLoader steamUserProfileManager = new SteamUserProfileDataLoader(steamLoadCallbackUserData);
        steamUserProfileManager.init(userId);
    }

    SteamLoadCallback<SteamUser> steamLoadCallbackUserData = new SteamLoadCallback<SteamUser>() {
        @Override
        public void onSuccess(SteamUser o) {
            steamUser = o;
            loadGameInfo();
        }

        @Override
        public void onError(String message) {
            mainView.showMessage(message);
        }
    };

    private void loadGameInfo() {
        SteamUserGameDataLoader steamUserGameDataLoader = new SteamUserGameDataLoader(steamUser.getSteamID64(), steamLoadCallbackGameData);
        steamUserGameDataLoader.init();
    }

    SteamLoadCallback<GameData> steamLoadCallbackGameData = new SteamLoadCallback<GameData>() {
        @Override
        public void onSuccess(GameData o) {
            mainView.showMessage("Success");
        }

        @Override
        public void onError(String message) {
            Log.i("", "");
            mainView.showMessage(message);
        }
    };


    @Override
    public void onItemClicked(int position) {

    }

    @Override
    public void onDestroy() {

    }
}
