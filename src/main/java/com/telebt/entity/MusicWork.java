package com.telebt.entity;

import com.utils.Consts;

/**
 * Main type, that contains characteristics of single or album.
 * @author ailiashenko
 * @version 0.1
 */
public class MusicWork {
	private String artist;
	private String workName;
	private String date;
	private String genres;
	private String rating;

	public MusicWork() {
	}

	public MusicWork(String artist, String workName, String date, String genres, String rating) {
		this.artist = artist;
		this.workName = workName;
		this.date = date;
		this.genres = genres;
		this.rating = rating;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getWorkName() {
		return workName;
	}

	public void setWorkName(String workName) {
		this.workName = workName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return Consts.EMOJI_ROCKSTAR + Consts.SPACE + "Artist: " + Consts.SPACE + artist + Consts.LINE_SEPARATOR
				+ Consts.EMOJI_MICRO + Consts.SPACE + "Name: " + Consts.SPACE + workName + Consts.LINE_SEPARATOR
				+ Consts.EMOJI_DATE + Consts.SPACE + "Date: " + Consts.SPACE + date + Consts.LINE_SEPARATOR
				+ Consts.EMOJI_GUITAR + Consts.SPACE + "Genres: " + Consts.SPACE + genres + Consts.LINE_SEPARATOR
				+ Consts.EMOJI_STAR + Consts.SPACE + rating.replace(" | Buy", "");
	}
}
