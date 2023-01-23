package org.example.dao;
import org.example.models.Book;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


public class JdbcBookDao implements BookDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcBookDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	@Override
	public Book getBook(int bookId) {
		Book book = null;

		String sqlGetBook = "SELECT title, series_id, has_audiobook, rating FROM book " +
				"WHERE book_id = ?;";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlGetBook, bookId);
		if(result.next()){
			book = mapRowToBook(result);
		}
		return book;

	}

	@Override
	public List<Book> getBookByTitle(String title) {
		List<Book> bookList = new ArrayList<>();
		String titleSearch = "%" + "title" + "%";
		String sqlGetBookByTitle = "SELECT b.book_id, b.title, s.series_name, g.genre_name, b.has_audiobook, b.rating " +
				"FROM book b " +
				"JOIN series s USING (series_id) " +
				"JOIN genre_books gb ON b.book_id = gb.book_id " +
				"JOIN genre g USING (genre_id) " +
				"WHERE b.title = ?;";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlGetBookByTitle, titleSearch);
		while(result.next()){
			bookList.add(mapRowToBook(result));
		}
		return bookList;
	}

	@Override
	public Book createBook(Book book) {
		String sqlCreateBook = "INSERT INTO book (title, has_audiobook, rating) VALUES (?,?,?) RETURNING book_id;";
		book.setBookId(jdbcTemplate.queryForObject(sqlCreateBook, int.class, book.getTitle(), book.getHasAudioBook(), book.getRating()));
		return book;
	}

	@Override
	public void updateBook(Book updatedBook) {
		String sqlUpdateBook = "UPDATE book SET series_id = ?, title = ?, has_audiobook = ?, rating = ?;";
		jdbcTemplate.update(sqlUpdateBook, updatedBook.getSeriesId(), updatedBook.getTitle(), updatedBook.getHasAudioBook(), updatedBook.getRating());
	}

	@Override
	public void deleteBook(int bookId) {
		String sqlDeleteBook = "DELETE FROM genre_books WHERE book_id = ?;" +
				"DELETE FROM author_books WHERE book_id = ?;" +
				"DELETE FROM book WHERE book_id = ?;";
		jdbcTemplate.update(sqlDeleteBook, bookId, bookId, bookId);
	}

	@Override
	public Book mapRowToBook(SqlRowSet rowSet) {
		Book book = new Book();
		book.setBookId(rowSet.getInt("book_id"));
		book.setSeriesId(rowSet.getInt("series_id"));
		book.setTitle(rowSet.getString("title"));
		book.setHasAudioBook(rowSet.getBoolean("has_audiobook"));
		book.setRating(rowSet.getDouble("rating"));
		return book;
	}
}
