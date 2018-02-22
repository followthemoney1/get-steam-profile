package com.ddpc.ggway.data.steam.interfaces

/**
 * Created by diha- on 10.01.2018.
 */

interface SteamLoadCallback<T> {
    fun onSuccess(o: T)
    fun onError(message: String)
}
