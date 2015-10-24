package com.first.whatson.apis.echonest;

import com.echonest.api.v4.Artist;
import com.echonest.api.v4.EchoNestAPI;
import com.echonest.api.v4.EchoNestException;
import java.util.List;

public class SimlarArtists {
	
    public static void main(String[] args) throws EchoNestException {
        EchoNestAPI echoNest = new EchoNestAPI(ApiKey.APIKEY);
        echoNest.setTraceSends(true);
        List<Artist> artists = echoNest.searchArtists("Bob Marley");

        if (artists.size() > 0) {
            Artist weezer = artists.get(0);
            System.out.println("Similar artists for " + weezer.getName());
            for (Artist simArtist : weezer.getSimilar(10)) {
                System.out.println("   " + simArtist.getName());
            }
        }
    }
}
