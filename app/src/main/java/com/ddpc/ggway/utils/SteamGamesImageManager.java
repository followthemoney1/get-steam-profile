package com.ddpc.ggway.utils;

import com.ddpc.ggway.R;

/**
 * Created by diha- on 25.03.2018.
 */

public class SteamGamesImageManager {
    //sames as in Constants file
    public static final Integer DOTA_ID = 570;
    public static final Integer CSGO_ID = 730;
    public static final Integer PUBG_ID = 578080;
    public static final Integer TOMCLANCY_ID = 359550;
    public static final Integer WARFRAME_ID = 230410;
    public static final Integer GTA5_ID = 271590;
    public static final Integer ARK_ID = 346110;

    public static Integer getResIdByGameId(int gameId){
        switch (gameId){
            case 570: return R.drawable.bkg_dota;
            case 730: return R.drawable.bkg_csgo;
            case 578080: return R.drawable.bkg_pubg;
            case 359550: return R.drawable.bkg_rainbow;
            case 230410: return R.drawable.bkg_warframe;
            case 271590: return R.drawable.bkg_gta;
            case 346110: return R.drawable.bkg_ark;
            default: return null;
        }
    }
}
