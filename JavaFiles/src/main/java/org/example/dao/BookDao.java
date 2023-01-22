package org.example.dao;

import org.example.models.Book;
import java.util.List;

public interface BookDao {
	Book getBook(int bookId);

	List<Book> getBookByTitle(String title);

	Book createBook(Book book);

	void updateBook(Book updatedBook);

	void deleteBook(int bookId);

}
