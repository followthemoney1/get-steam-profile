package com.ddpc.ggway.data.steam

import com.ddpc.ggway.data.steam.models.GameData
import com.ddpc.ggway.data.steam.models.Response
import com.ddpc.ggway.data.steam.models.SteamUser
import java.io.Serializable

/**
 * Created by diha- on 05.03.2018.
 */
data class UserData(var steamUser:SteamUser?, var gameData: Response?):Serializable {
}