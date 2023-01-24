package org.example;

import org.apache.commons.dbcp2.BasicDataSource;
import org.example.dao.*;
import org.example.view.Menu;

import javax.sql.DataSource;

public class BookProjectCLI {

	private final String MAIN_MENU_BOOKS = "Books";
	private final String MAIN_MENU_AUTHORS = "Authors";
	private final String MAIN_MENU_SERIES = "Series";
	private final String MAIN_MENU_GENRES = "Genres";
	private String[] MAIN_MENU_OPTIONS;

	private final String BOOK_MENU_FIND_BY_ID = "Find book by ID";
	private final String BOOK_MENU_FIND_BY_TITLE = "Find book by title";
	private final String BOOK_MENU_FIND_BY_SERIES = "Find books in series";
	private final String BOOK_MENU_ADD_BOOK = "Add new book";
	private final String BOOK_MENU_UPDATE_BOOK = "Update Book ntry";
	private final String BOOK_MENU_DELETE_BOOK = "Delete book entry";
	private final String BOOK_MENU_SHOW_READ = "Show Finished Books";
	private final String BOOK_MENU_UNREAD = "Show Unfinished Books";
	private String[] BOOK_MENU_OPTIONS;

	private final String AUTHOR_MENU_FIND_BY_ID = "Find author by ID";
	private final String AUTHOR_MENU_FIND_BY_NAME = "Find author by name";
	private final String AUTHOR_MENU_FIND_BY_BOOK_TITLE = "Find author by book title";
	private final String AUTHOR_MENU_ADD = "Add new author";
	private final String AUTHOR_MENU_UPDATE = "Update author entry";
	private final String AUTHOR_MENU_DELETE = "Delete author entry";
	private final String AUTHOR_MENU_ASSIGN_BOOK = "Assign author to book";
	private final String AUTHOR_MENU_UNASSIGN_BOOK = "Unassign author to book";
	private String[] AUTHOR_MENU_OPTIONS;


	private final Menu menu;
	private final AuthorDao authorDao;
	private final BookDao bookDao;
	private final SeriesDao seriesDao;
	private final GenreDao genreDao;

	public static void main(String[] args) {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/bookproject");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");

		BookProjectCLI application = new BookProjectCLI(dataSource);

	}

	public BookProjectCLI(DataSource dataSource) {
		this.menu = new Menu(System.in, System.out);
		MAIN_MENU_OPTIONS = new String[]{MAIN_MENU_BOOKS, MAIN_MENU_AUTHORS,
				MAIN_MENU_SERIES, MAIN_MENU_GENRES};

		BOOK_MENU_OPTIONS = new String[]{BOOK_MENU_FIND_BY_ID,
				BOOK_MENU_FIND_BY_TITLE, BOOK_MENU_FIND_BY_SERIES, BOOK_MENU_SHOW_READ,
				BOOK_MENU_UNREAD, BOOK_MENU_ADD_BOOK, BOOK_MENU_UPDATE_BOOK, BOOK_MENU_DELETE_BOOK};

		AUTHOR_MENU_OPTIONS = new String[]{AUTHOR_MENU_FIND_BY_ID,
				AUTHOR_MENU_FIND_BY_NAME, AUTHOR_MENU_FIND_BY_BOOK_TITLE, AUTHOR_MENU_ADD,
				AUTHOR_MENU_UPDATE, AUTHOR_MENU_DELETE, AUTHOR_MENU_ASSIGN_BOOK, AUTHOR_MENU_UNASSIGN_BOOK};


		this.authorDao = new JdbcAuthorDao(dataSource);
		this.bookDao = new JdbcBookDao(dataSource);
		this.seriesDao = new JdbcSeriesDao(dataSource);
		this.genreDao = new JdbcGenreDao(dataSource);
	}

	private void run(){
		System.out.println("Hello");
	}
}