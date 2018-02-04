package com.ddpc.ggway.data.steam.models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by diha- on 09.01.2018.
 */
@Root(name = "mostPlayedGame" ,strict = false )
public class MostPlayedGame {
    @Element(name = "gameName", required = false)
    String gameName;

    @Element(name = "gameLink", required = false)
    String gameLink;

    @Element(name = "gameIcon", required = false)
    String gameIcon;

    @Element(name = "gameLogo", required = false)
    String gameLogo;

    @Element(name = "gameLogoSmall", required = false)
    String gameLogoSmall;

    @Element(name = "hoursPlayed", required = false)
    String hoursPlayed;

    @Element(name = "hoursOnRecord", required = false)
    String hoursOnRecord;

    @Element(name = "statsName", required = false)
    String statsName;


}
