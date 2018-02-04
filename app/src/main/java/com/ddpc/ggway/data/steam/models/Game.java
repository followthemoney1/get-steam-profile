package com.ddpc.ggway.data.steam.models;

/**
 * Created by diha- on 10.01.2018.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Game {

    @SerializedName("appid")
    @Expose
    private Integer appid;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("playtime_2weeks")
    @Expose
    private Integer playtime2weeks;
    @SerializedName("playtime_forever")
    @Expose
    private Integer playtimeForever;
    @SerializedName("img_icon_url")
    @Expose
    private String imgIconUrl;
    @SerializedName("img_logo_url")
    @Expose
    private String imgLogoUrl;

    public Integer getAppid() {
        return appid;
    }

    public void setAppid(Integer appid) {
        this.appid = appid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPlaytime2weeks() {
        return playtime2weeks;
    }

    public void setPlaytime2weeks(Integer playtime2weeks) {
        this.playtime2weeks = playtime2weeks;
    }

    public Integer getPlaytimeForever() {
        return playtimeForever;
    }

    public void setPlaytimeForever(Integer playtimeForever) {
        this.playtimeForever = playtimeForever;
    }

    public String getImgIconUrl() {
        return imgIconUrl;
    }

    public void setImgIconUrl(String imgIconUrl) {
        this.imgIconUrl = imgIconUrl;
    }

    public String getImgLogoUrl() {
        return imgLogoUrl;
    }

    public void setImgLogoUrl(String imgLogoUrl) {
        this.imgLogoUrl = imgLogoUrl;
    }

}