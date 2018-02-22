package com.ddpc.ggway.data.steam

/**
 * Created by diha- on 09.01.2018.
 */

object SteamConstants {
    const val STEAM_KEY = "key=949DDA17D1A94CB9D387F2BE0727EB5F"

    const val STEAM_PROFILE_URL_START = "http://steamcommunity.com/id/"
    const  val STEAM_PROFILE_URL_END = "/?xml=1"
    //http://steamcommunity.com/id/yourusername/?xml=1

    const val STEAM_PROFILE_GAME_START = "http://api.steampowered.com/IPlayerService/GetRecentlyPlayedGames/v1/"
    //https://api.steampowered.com/IPlayerService/GetRecentlyPlayedGames/v1/?key=949DDA17D1A94CB9D387F2BE0727EB5F&format=json&steamid=76561198140055626
}
