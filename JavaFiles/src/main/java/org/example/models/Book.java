package org.example.models;

public class Book {
	private int bookId;
	private int seriesId;
	private String title;
	private boolean hasAudioBook;
	private double rating;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getSeriesId() {
		return seriesId;
	}

	public void setSeriesId(int seriesId) {
		this.seriesId = seriesId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean getHasAudioBook() {
		return hasAudioBook;
	}

	public void setHasAudioBook(boolean hasAudioBook) {
		this.hasAudioBook = hasAudioBook;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
}
