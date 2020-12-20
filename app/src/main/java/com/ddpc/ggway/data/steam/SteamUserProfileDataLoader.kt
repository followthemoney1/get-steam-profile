package com.ddpc.ggway.data.steam


import android.annotation.SuppressLint
import android.util.Log

import com.ddpc.ggway.data.steam.interfaces.SteamLoadCallback
import com.ddpc.ggway.data.steam.interfaces.SteamProfileInterface
import com.ddpc.ggway.data.steam.models.SteamUser

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import java.io.Serializable

/**
 * Created by diha- on 09.01.2018.
 */

class SteamUserProfileDataLoader(internal var callback: SteamLoadCallback<SteamUser>) : Callback<SteamUser> {

    fun init(userId: String) {
        val retrofit = Retrofit.Builder()
                .baseUrl(SteamConstants.STEAM_PROFILE_URL_START)
                .client(OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build()

        val service = retrofit.create(SteamProfileInterface::class.java)
        val steamUserCall = service.getSteamUserData(userId)
        steamUserCall.enqueue(this)
    }

    @SuppressLint("LongLogTag")
    override fun onResponse(call: Call<SteamUser>, response: Response<SteamUser>) {
        Log.d("SteamUserProfileDataLoader,onResponse,", response.toString())
        if (response.isSuccessful) {
            val steamUser = response.body()
            callback.onSuccess(steamUser!!)
            Log.d("SteamUserProfileDataLoader, onResponse,", steamUser.toString())
        }
    }

    @SuppressLint("LongLogTag")
    override fun onFailure(call: Call<SteamUser>, t: Throwable) {
        callback.onError(t.message!!)
        Log.e("SteamUserProfileDataLoader, onFailure,", t.toString())
    }
}
