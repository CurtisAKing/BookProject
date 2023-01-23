package org.example.models;

public class Book {
	private int bookId;
	private int serialId;
	private String title;
	private boolean hasAudioBook;
	private double rating;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getSerialId() {
		return serialId;
	}

	public void setSerialId(int serialId) {
		this.serialId = serialId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isHasAudioBook() {
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
