package se.altran.java.lambda.streams;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import se.altran.java.lambda.streams.album.Album;
import se.altran.java.lambda.streams.album.Rating;

public class AlbumFinderTest {
	@Test
	public void getTheOldestFantasticAlbum() {
		Album expected = new Album("Ten", "Pearl Jam", 1992, Rating.FANTASTIC);
		assertEquals(expected, AlbumFinder.getTheOldestFantasticAlbum());
	}

	@Test
	public void checkGetAllAlbumsWithRatingGreatOrHigherFromTheNinetiesSortedByArtist() {
		List<Album> expected = Arrays.asList(new Album("Sixteen Stone", "Bush",
				1994, Rating.FANTASTIC), new Album("Ten", "Pearl Jam", 1992,
				Rating.FANTASTIC), new Album("Pablo Honey", "Radiohead", 1993,
				Rating.FANTASTIC));
		List<Album> actual = AlbumFinder
				.getAllAlbumsWithRatingGreatOrHigherFromTheNinetiesSortedByArtist();
		assertEquals("Not the right number of albums returned!",
				expected.size(), actual.size());
		assertTrue("Wrong albums returned!", expected.containsAll(actual));
		assertEquals("Albums returned in the wrong order!", expected, actual);
	}

	@Test
	public void getTheNumberOfAlbumsWithTheSpecifiedRatingReturnsZeroForRatingDecent() {
		long result = AlbumFinder
				.getTheNumberOfAlbumsWithTheSpecifiedRating(Rating.DECENT);
		assertEquals(0, result);
	}
	@Test
	public void getTheNumberOfAlbumsWithTheSpecifiedRatingReturnsThreeForRatingFantastic() {
		long result = AlbumFinder
				.getTheNumberOfAlbumsWithTheSpecifiedRating(Rating.FANTASTIC);
		assertEquals(3, result);
	}
}
