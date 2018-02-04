package com.ddpc.ggway.data.steam.interfaces;

/**
 * Created by diha- on 10.01.2018.
 */

public interface SteamLoadCallback<T> {
    void onSuccess(T o);
    void onError(String message);
}
