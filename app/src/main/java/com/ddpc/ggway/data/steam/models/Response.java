package com.ddpc.ggway.data.steam.models;

/**
 * Created by diha- on 10.01.2018.
 */
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("total_count")
    @Expose
    private Integer totalCount;
    @SerializedName("games")
    @Expose
    private List<Game> games = null;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

}