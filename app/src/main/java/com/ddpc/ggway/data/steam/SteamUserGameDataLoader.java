package com.ddpc.ggway.data.steam;

import android.annotation.SuppressLint;
import android.util.Log;

import com.ddpc.ggway.data.steam.interfaces.SteamGameInterface;
import com.ddpc.ggway.data.steam.interfaces.SteamLoadCallback;
import com.ddpc.ggway.data.steam.models.GameData;
import com.ddpc.ggway.data.steam.models.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by diha- on 10.01.2018.
 */

public class SteamUserGameDataLoader implements Callback<GameData> {
    String userId;
    SteamLoadCallback<GameData> callback;

    public SteamUserGameDataLoader(String userId, SteamLoadCallback<GameData> callback) {
        this.userId = userId;
        this.callback = callback;
    }

    public void init(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(SteamConstants.STEAM_PROFILE_GAME_START)
                .addConverterFactory( GsonConverterFactory.create(gson))
                .build();

        SteamGameInterface service = retrofit.create(SteamGameInterface.class);
        Call<GameData> steamUserCall = service.getSteamGameData(userId);
        steamUserCall.enqueue(this);
    }


    @SuppressLint("LongLogTag")
    @Override
    public void onResponse(Call<GameData> call, retrofit2.Response<GameData> response) {
        Log.d("SteamUserGameDataLoader,onResponse,", response.toString());
        if (response.isSuccessful()) {
            GameData resp = response.body();
            callback.onSuccess(resp);
            Log.d("SteamUserGameDataLoader, onResponse,", resp.toString());
        }
    }

    @SuppressLint("LongLogTag")
    @Override
    public void onFailure(Call<GameData> call, Throwable t) {
        callback.onError(t.getMessage());
        Log.d("SteamUserGameDataLoader, onFailure,", t.toString());
    }
}
