package org.example.dao;

import org.example.models.Author;
import java.util.List;

public interface AuthorDao {
	Author getAuthor(int authorID);

	List<Author> getAuthorsByBook(String title);

	List<Author> getAuthorsByName(String firstName, String lastName);

	Author createAuthor(Author author);

	void updateAuthor(Author updatedAuthor);

	void deleteAuthor(Author authorToDelete);

	void addAuthorToBook(int authorId, int bookId);

	void removeAuthorFromBook(int authorId, int bookId);

}
