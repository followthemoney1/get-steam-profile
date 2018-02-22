package com.ddpc.ggway.data.steam

import android.annotation.SuppressLint
import android.util.Log

import com.ddpc.ggway.data.steam.interfaces.SteamGameInterface
import com.ddpc.ggway.data.steam.interfaces.SteamLoadCallback
import com.ddpc.ggway.data.steam.models.GameData
import com.ddpc.ggway.data.steam.models.Response
import com.google.gson.Gson
import com.google.gson.GsonBuilder

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by diha- on 10.01.2018.
 */

class SteamUserGameDataLoader(internal var userId: String, internal var callback: SteamLoadCallback<GameData>) : Callback<GameData> {

    fun init() {
        val gson = GsonBuilder()
                .setLenient()
                .create()

        val retrofit = Retrofit.Builder()
                .baseUrl(SteamConstants.STEAM_PROFILE_GAME_START)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

        val service = retrofit.create(SteamGameInterface::class.java)
        val steamUserCall = service.getSteamGameData(userId)
        steamUserCall.enqueue(this)
    }


    @SuppressLint("LongLogTag")
    override fun onResponse(call: Call<GameData>, response: retrofit2.Response<GameData>) {
        Log.d("SteamUserGameDataLoader,onResponse,", response.toString())
        if (response.isSuccessful) {
            val resp = response.body()
            callback.onSuccess(resp!!)
            Log.d("SteamUserGameDataLoader, onResponse,", resp!!.toString())
        }
    }

    @SuppressLint("LongLogTag")
    override fun onFailure(call: Call<GameData>, t: Throwable) {
        callback.onError(t.message!!)
        Log.d("SteamUserGameDataLoader, onFailure,", t.toString())
    }
}
