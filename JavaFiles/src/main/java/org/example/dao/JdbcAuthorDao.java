package org.example.dao;

import org.example.models.Author;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcAuthorDao implements AuthorDao{

	private final JdbcTemplate jdbcTemplate;

	public JdbcAuthorDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	@Override
	public Author getAuthor(int authorID) {
		Author author = null;
		String sqlGetAuthor = "SELECT first_name, last_name, birthday, birth_place " +
				"FROM author " +
				"WHERE author_id = ?;";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlGetAuthor, authorID);
		if(result.next()){
			author = mapRowToAuthor(result);
		}
		return author;
	}

	@Override
	public List<Author> getAuthorsByBook(String title) {
		List<Author> authorList = new ArrayList<>();
		String sqlGetAuthorByBook = "SELECT first_name, last_name, birthday, birth_place " +
				"FROM author a " +
				"JOIN author_books ab " +
				"USING (author_id) " +
				"WHERE ab.book_id = (SELECT book_id FROM book WHERE title = ?);";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlGetAuthorByBook, title);
		while(result.next()){
			authorList.add(mapRowToAuthor(result));
		}
		return authorList;
	}

	@Override
	public List<Author> getAuthorsByName(String firstName, String lastName) {

		List<Author> author = new ArrayList<>();
		String fields = "author_id, first_name, last_name, birthday, birth_place";
		String firstNameSearch = "%" + firstName + "%";
		String lastNameSearch = "%" + lastName + "%";

		String sql = "SELECT " +
				fields +
				"FROM author WHERE first_name ILIKE ? AND last_name ILIKE ?;";
		String firstOnly = "SELECT " +
				fields +
				" FROM author WHERE first_name ILIKE ?;";
		String lastOnly = "SELECT " +
				fields +
				" FROM author WHERE last_name ILIKE ?;";
		String allSQL = "SELECT " +
				fields +
				" FROM author;";
		String exact = "SELECT " +
				fields +
				" FROM author WHERE first_name = ? AND last_name = ?;";
		SqlRowSet results;

		results = jdbcTemplate.queryForRowSet(exact, firstNameSearch, lastNameSearch);

		while (results.next()) {
			author.add(mapRowToAuthor(results));
		}

		if (author.isEmpty()) {

			if (firstNameSearch.equals("%%") && lastNameSearch.equals("%%")) {
				results = jdbcTemplate.queryForRowSet(allSQL);
			} else if (firstNameSearch.equals("%%")) {
				results = jdbcTemplate.queryForRowSet(lastOnly, lastNameSearch);
			} else if (lastNameSearch.equals("%%")) {
				results = jdbcTemplate.queryForRowSet(firstOnly, firstNameSearch);
			} else {
				results = jdbcTemplate.queryForRowSet(sql, firstNameSearch, lastNameSearch);
			}

			while (results.next()) {
				author.add(mapRowToAuthor(results));
			}
		}

		return author;
	}

	@Override
	public Author createAuthor(Author author) {
		String sqlCreateAuthor = "INSERT INTO author (first_name, last_name, birthday, birth_place) VALUES (?,?,?,?) RETURNING author_id;";
		author.setAuthorId(jdbcTemplate.queryForObject(sqlCreateAuthor, int.class, author.getFirstName(), author.getLastName(),
				author.getBirthday(), author.getBirthplace()));
		return author;
	}

	@Override
	public void updateAuthor(Author updatedAuthor) {
		String sqlUpdateAuthor = "UPDATE author SET first_name = ?, last_name = ?, birthday = ?, birth_place = ? " +
				"WHERE author_id = ?;";
		jdbcTemplate.update(sqlUpdateAuthor, updatedAuthor.getFirstName(), updatedAuthor.getLastName(),
				updatedAuthor.getBirthday(), updatedAuthor.getBirthplace());
	}

	@Override
	public void deleteAuthor(Author authorToDelete) {
		String sqlDeleteAuthorBooks = "DELETE FROM author_books WHERE author_id = ?;";
		String sqlDeleteAuthor = "DELETE FROM author WHERE author_id = ?;";
		jdbcTemplate.update(sqlDeleteAuthorBooks, authorToDelete.getAuthorId());
		jdbcTemplate.update(sqlDeleteAuthor, authorToDelete.getAuthorId());
	}

	@Override
	public void addAuthorToBook(int authorId, int bookId) {
		String sqlAddAuthorToBook = "INSERT INTO author_books (author_id, book_id) VALUES ((SELECT author_id FROM author " +
				"WHERE author_id = ?)" +
				"(SELECT book_id FROM book WHERE book_id = ?));";
		jdbcTemplate.update(sqlAddAuthorToBook, authorId, bookId);

	}

	@Override
	public void removeAuthorFromBook(int authorId, int bookId) {
		String sqlAddAuthorToBook = "DELETE FROM author_books WHERE author_id = ? AND " +
				"book_id = ?;";
		jdbcTemplate.update(sqlAddAuthorToBook, authorId, bookId);

	}

	@Override
	public Author mapRowToAuthor(SqlRowSet rowSet) {
		Author author = new Author();
		author.setAuthorId(rowSet.getInt("author_id"));
		author.setBirthday(rowSet.getDate("birthdate").toLocalDate());
		author.setBirthplace(rowSet.getString("birth_place"));
		author.setFirstName(rowSet.getString("first_name"));
		author.setLastName(rowSet.getString("last_name"));
		return author;
	}


}
