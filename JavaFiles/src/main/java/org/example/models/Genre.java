package org.example.models;

public class Genre {
	private int genreID;
	private String genreName;

	public Genre(String genreName) {
		this.genreName = genreName;
	}

	public int getGenreID() {
		return genreID;
	}

	public void setGenreID(int genreID) {
		this.genreID = genreID;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
}
