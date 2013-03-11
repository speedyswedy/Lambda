package se.altran.java.lambda.streams.album;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlbumCollection {
    private static List<Album> albums = Arrays.asList(new Album("Ten", "Pearl Jam", 1992, Rating.FANTASTIC),
            new Album("Everything All the Time", "Band of Horses", 2006, Rating.GREAT),
            new Album("Sixteen Stone", "Bush", 1994, Rating.FANTASTIC),
            new Album("Made of Bricks", "Kate Nash", 2007, Rating.GREAT),
            new Album("Naked Number One", "Tomas di Leva", 1993, Rating.AWFUL));

    public static List<Album> getAlbums() {
        return new ArrayList<Album>(albums);
    }
}
