package com.ddpc.ggway.data.steam.models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

import java.util.List;

/**
 * Created by diha- on 09.01.2018.
 */
@Root(name = "profile", strict = false  )
public class SteamUser {

    @Element(name = "steamID64", required = false)
    String steamID64;

    @Element(name = "steamID", required = false)
    String steamID;

    @Element(name = "stateMessage", required = false)
    String stateMessage;

    @Element(name = "avatarIcon", required = false)
    String avatarIcon;

    @Element(name = "avatarFull", required = false)
    String avatarFull;

    @Element(name = "vacBanned", required = false)
    String vacBanned;

    @Element(name = "customURL", required = false)
    String customURL;

    @Element(name = "location", required = false)
    String location;

    @Element(name = "realname", required = false)
    String realname;

    @Element(name = "summary", required = false)
    String summary;

    @Element(name = "onlineState", required = false)
    String onlineState;

    @Element(name = "privacyState", required = false)
    String privacyState;

    @Element(name = "visibilityState", required = false)
    String visibilityState;

    @Element(name = "avatarMedium", required = false)
    String avatarMedium;

    @Element(name = "tradeBanState", required = false)
    String tradeBanState;

    @Element(name = "isLimitedAccount", required = false)
    String isLimitedAccount;

    @Element(name = "memberSince", required = false)
    String memberSince;

    @Element(name = "steamRating", required = false)
    String steamRating;

    @Element(name = "hoursPlayed2Wk", required = false)
    String hoursPlayed2Wk;

    @Element(name = "headline", required = false)
    String headline;

    @ElementList(entry = "mostPlayedGames", inline = false, required = false)
    List<MostPlayedGame> mostPlayedGames;

    @Element(name = "mostPlayedGame", required = false)
   String mostPlayedGame;

    @ElementList(entry = "groups", inline = false, required = false)
    List<Group> groups;

    @Element(name = "group", required = false)
   String group;


    public String getSteamID64() {
        return steamID64;
    }

    public void setSteamID64(String steamID64) {
        this.steamID64 = steamID64;
    }

    public String getSteamID() {
        return steamID;
    }

    public void setSteamID(String steamID) {
        this.steamID = steamID;
    }

    public String getStateMessage() {
        return stateMessage;
    }

    public void setStateMessage(String stateMessage) {
        this.stateMessage = stateMessage;
    }

    public String getAvatarIcon() {
        return avatarIcon;
    }

    public void setAvatarIcon(String avatarIcon) {
        this.avatarIcon = avatarIcon;
    }

    public String getAvatarFull() {
        return avatarFull;
    }

    public void setAvatarFull(String avatarFull) {
        this.avatarFull = avatarFull;
    }

    public String getVacBanned() {
        return vacBanned;
    }

    public void setVacBanned(String vacBanned) {
        this.vacBanned = vacBanned;
    }

    public String getCustomURL() {
        return customURL;
    }

    public void setCustomURL(String customURL) {
        this.customURL = customURL;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getOnlineState() {
        return onlineState;
    }

    public void setOnlineState(String onlineState) {
        this.onlineState = onlineState;
    }

    public String getPrivacyState() {
        return privacyState;
    }

    public void setPrivacyState(String privacyState) {
        this.privacyState = privacyState;
    }

    public String getVisibilityState() {
        return visibilityState;
    }

    public void setVisibilityState(String visibilityState) {
        this.visibilityState = visibilityState;
    }

    public String getAvatarMedium() {
        return avatarMedium;
    }

    public void setAvatarMedium(String avatarMedium) {
        this.avatarMedium = avatarMedium;
    }

    public String getTradeBanState() {
        return tradeBanState;
    }

    public void setTradeBanState(String tradeBanState) {
        this.tradeBanState = tradeBanState;
    }

    public String getIsLimitedAccount() {
        return isLimitedAccount;
    }

    public void setIsLimitedAccount(String isLimitedAccount) {
        this.isLimitedAccount = isLimitedAccount;
    }

    public String getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(String memberSince) {
        this.memberSince = memberSince;
    }

    public String getSteamRating() {
        return steamRating;
    }

    public void setSteamRating(String steamRating) {
        this.steamRating = steamRating;
    }

    public String getHoursPlayed2Wk() {
        return hoursPlayed2Wk;
    }

    public void setHoursPlayed2Wk(String hoursPlayed2Wk) {
        this.hoursPlayed2Wk = hoursPlayed2Wk;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public List<MostPlayedGame> getMostPlayedGames() {
        return mostPlayedGames;
    }

    public void setMostPlayedGames(List<MostPlayedGame> mostPlayedGames) {
        this.mostPlayedGames = mostPlayedGames;
    }

    public List getGroups() {
        return groups;
    }

    public void setGroups(List groups) {
        this.groups = groups;
    }
}
