package org.example.dao;


import org.example.models.Genre;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcGenreDao implements GenreDao {
	private final JdbcTemplate jdbcTemplate;

	public JdbcGenreDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Genre getGenre(int genreId) {
		Genre genre = null;
		String sqlGetGenre = "SELECT genre_id, genre_name FROM genre WHERE genre_id = ?;";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlGetGenre, genreId);
		if(result.next()){
			genre = mapRowToGenre(result);
		}
		return genre;
	}

	@Override
	public List<Genre> getGenreByName(String name) {
		List<Genre> genreList = new ArrayList<>();
		String sqlGetByName = "SELECT genre_id, genre_name FROM genre WHERE genre_name = ?;";
		String nameSearch = "%" + name + "%";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlGetByName, name);

		if(result.next()){
			genreList.add(mapRowToGenre(result));
		}

		if (genreList.isEmpty()){
			result = jdbcTemplate.queryForRowSet(sqlGetByName, nameSearch);
			genreList.add(mapRowToGenre(result));
		}
		return genreList;
	}

	@Override
	public Genre createGenre(Genre genre) {
		String sqlCreate = "INSERT INTO genre (genre_name) VALUES (?) RETURNING genre_id;";
		genre.setGenreID(jdbcTemplate.queryForObject(sqlCreate, int.class, genre.getGenreName()));
		return genre;
	}

	@Override
	public void updateGenre(Genre updatedGenre) {
		String sqlUpdate = "UPDATE genre SET genre_name = ? WHERE genre_id = ?;";
		jdbcTemplate.update(sqlUpdate, updatedGenre.getGenreName() ,updatedGenre.getGenreID());
	}

	@Override
	public void deleteGenre(int genreId) {
		String sqlDelete = "DELETE FROM genre_books WHERE genre_id = ?; " +
				"DELETE FROM genre WHERE genre_id = ?;";
		jdbcTemplate.update(sqlDelete, genreId, genreId);
	}

	@Override
	public void addGenreToBook(int genreId, int bookId) {
		String sqlAddToGenreBooks =  "INSERT INTO genre_books (genre_id, book_id) VALUES (?,?);";
		jdbcTemplate.update(sqlAddToGenreBooks, genreId, bookId);
	}

	@Override
	public void deleteGenreFromBook(int genreId, int bookId) {
		String sqlDeleteFromGenreBooks = "DELETE FROM genre_books WHERE genre_id = ? AND book_id = ?;";
		jdbcTemplate.update(sqlDeleteFromGenreBooks, genreId, bookId);
	}

	@Override
	public Genre mapRowToGenre(SqlRowSet rowSet) {
		Genre genre = new Genre();
		genre.setGenreID(rowSet.getInt("genre_id"));
		genre.setGenreName(rowSet.getString("genre_name"));
		return genre;
	}
}
