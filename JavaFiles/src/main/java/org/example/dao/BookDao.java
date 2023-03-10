package org.example.dao;

import org.example.models.Book;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.List;

public interface BookDao {
	Book getBook(int bookId);

	List<Book> getBookByTitle(String title);

	public List<Book> getBookBySeries(String name);

	Book createBook(Book book);

	void updateBook(Book updatedBook);

	void deleteBook(int bookId);

	Book mapRowToBook(SqlRowSet rowSet);

}
