package org.example.dao;

import org.example.models.Genre;
import java.util.List;

public interface GenreDao {

	Genre getGenre (int genreId);

	List<Genre> getGenreByName(String name);

	Genre createGenre(Genre genre);

	void updateGenre(Genre updatedGenre);

	void deleteGenre(int genreId);

	void addGenreToBook(int genreId, int bookId);

	void deleteGenreFromBook(int genreId, int bookId);

}
