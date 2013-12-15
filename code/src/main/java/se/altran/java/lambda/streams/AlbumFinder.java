package se.altran.java.lambda.streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import se.altran.java.lambda.streams.album.Album;
import se.altran.java.lambda.streams.album.AlbumCollection;
import se.altran.java.lambda.streams.album.Rating;

public class AlbumFinder {

	public static Album getTheOldestFantasticAlbum() {
		List<Album> fantasticAlbums = new ArrayList<>();

		for (Album album : AlbumCollection.getAlbums()) {
			if (album.getRating() == Rating.FANTASTIC) {
				fantasticAlbums.add(album);
			}
		}
		Collections.sort(fantasticAlbums, new Comparator<Album>() {
			public int compare(Album a1, Album a2) {
				return a1.getYear() - a2.getYear();
			}
		});
		return fantasticAlbums.get(0);
	}

	public static List<Album> getAllAlbumsWithRatingGreatOrHigherFromTheNinetiesSortedByArtist() {
		List<Album> highRatedAlbums = new ArrayList<>();
		for (Album a : AlbumCollection.getAlbums()) {
			if (a.getRating().ordinal() >= Rating.GREAT.ordinal()
					&& a.getYear() > 1989 && a.getYear() < 2000) {
				highRatedAlbums.add(a);
			}
		}
		Collections.sort(highRatedAlbums, new Comparator<Album>() {
			public int compare(Album a1, Album a2) {
				return a1.getArtist().compareTo(a2.getArtist());
			}
		});
		return highRatedAlbums;
	}

	public static long getTheNumberOfAlbumsWithTheSpecifiedRating(Rating rating) {
		long count = 0;
		for (Album a : AlbumCollection.getAlbums()) {
			if (a.getRating() == rating) {
				count++;
			}
		}
		return count;
	}
}
