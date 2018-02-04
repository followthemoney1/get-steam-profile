package com.ddpc.ggway.data.steam;



import android.annotation.SuppressLint;
import android.util.Log;

import com.ddpc.ggway.data.steam.interfaces.SteamLoadCallback;
import com.ddpc.ggway.data.steam.interfaces.SteamProfileInterface;
import com.ddpc.ggway.data.steam.models.SteamUser;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by diha- on 09.01.2018.
 */

public class SteamUserProfileDataLoader implements Callback<SteamUser>{
    SteamLoadCallback<SteamUser> callback;

    public SteamUserProfileDataLoader( SteamLoadCallback<SteamUser> callback) {
      this.callback = callback;
    }

    public void init(String userId){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(SteamConstants.STEAM_PROFILE_URL_START)
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        SteamProfileInterface service = retrofit.create(SteamProfileInterface.class);
        Call<SteamUser> steamUserCall = service.getSteamUserData(userId);
        steamUserCall.enqueue(this);
    }

    @SuppressLint("LongLogTag")
    @Override
    public void onResponse(Call<SteamUser> call, Response<SteamUser> response) {
        Log.d("SteamUserProfileDataLoader,onResponse,", response.toString());
        if (response.isSuccessful()) {
            SteamUser steamUser = response.body();
            callback.onSuccess(steamUser);
            Log.d("SteamUserProfileDataLoader, onResponse,", steamUser.toString());
        }
    }

    @SuppressLint("LongLogTag")
    @Override
    public void onFailure(Call<SteamUser> call, Throwable t) {
        callback.onError(t.getMessage());
        Log.e("SteamUserProfileDataLoader, onFailure,", t.toString());
    }
}
