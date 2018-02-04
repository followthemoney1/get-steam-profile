package com.ddpc.ggway.data.steam.interfaces;

import com.ddpc.ggway.data.steam.SteamConstants;
import com.ddpc.ggway.data.steam.models.GameData;
import com.ddpc.ggway.data.steam.models.SteamUser;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by diha- on 09.01.2018.
 */

public interface SteamProfileInterface {
    @GET("{userId}" + SteamConstants.STEAM_PROFILE_URL_END)
    Call<SteamUser> getSteamUserData(@Path("userId") String userId);
}
