package se.altran.java.lambda.streams.album;

public class Album {
    private final String title;
    private final String artist;
    private final int year;
    private final Rating rating;

    public Album(String title, String artist, int year, Rating rating) {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getYear() {
        return year;
    }

    public Rating getRating() {
        return rating;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Album)) {
            return false;
        }
        Album other = (Album) obj;
        return getTitle().equals(other.getTitle()) &&
                getArtist().equals(other.getArtist()) &&
                (getYear() == other.getYear()) &&
                (getRating() == other.getRating());
    }

    @Override
    public String toString() {
        return String.format("Title: %s, Artist: %s, Year: %d, Rating: %s", this.title, this.artist, this.year, this.rating);
    }
}