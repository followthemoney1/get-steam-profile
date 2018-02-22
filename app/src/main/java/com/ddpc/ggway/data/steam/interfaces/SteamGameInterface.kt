package com.ddpc.ggway.data.steam.interfaces

import com.ddpc.ggway.data.steam.SteamConstants
import com.ddpc.ggway.data.steam.models.GameData
import com.ddpc.ggway.data.steam.models.Response
import com.ddpc.ggway.data.steam.models.SteamUser

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

import com.ddpc.ggway.data.steam.SteamConstants.STEAM_KEY

/**
 * Created by diha- on 10.01.2018.
 */

interface SteamGameInterface {
    @GET("?" + SteamConstants.STEAM_KEY + "&format=json")//+"&steamid={userId}"
    fun getSteamGameData(@Query("steamid") steamid: String): Call<GameData>
}
