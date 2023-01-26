package org.example.view;

public final class MenuConstants {
	public static final String MAIN_MENU_BOOKS = "Books";
	public static final String MAIN_MENU_AUTHORS = "Authors";
	public static final String MAIN_MENU_SERIES = "Series";
	public static final String MAIN_MENU_GENRES = "Genres";
	public static String[] MAIN_MENU_OPTIONS = new String[]{MAIN_MENU_BOOKS, MAIN_MENU_AUTHORS,
			MAIN_MENU_SERIES, MAIN_MENU_GENRES};

	public static final String BOOK_MENU_FIND_BY_ID = "Find book by ID";
	public static final String BOOK_MENU_FIND_BY_TITLE = "Find book by title";
	public static final String BOOK_MENU_FIND_BY_SERIES = "Find books in series";
	public static final String BOOK_MENU_ADD_BOOK = "Add new book";
	public static final String BOOK_MENU_UPDATE_BOOK = "Update Book ntry";
	public static final String BOOK_MENU_DELETE_BOOK = "Delete book entry";
	public static final String BOOK_MENU_SHOW_READ = "Show Finished Books";
	public static final String BOOK_MENU_UNREAD = "Show Unfinished Books";
	public static final String[] BOOK_MENU_OPTIONS = new String[]{BOOK_MENU_FIND_BY_ID,
			BOOK_MENU_FIND_BY_TITLE, BOOK_MENU_FIND_BY_SERIES, BOOK_MENU_SHOW_READ,
			BOOK_MENU_UNREAD, BOOK_MENU_ADD_BOOK, BOOK_MENU_UPDATE_BOOK, BOOK_MENU_DELETE_BOOK};

	public static final String AUTHOR_MENU_FIND_BY_ID = "Find author by ID";
	public static final String AUTHOR_MENU_FIND_BY_NAME = "Find author by name";
	public static final String AUTHOR_MENU_FIND_BY_BOOK_TITLE = "Find author by book title";
	public static final String AUTHOR_MENU_ADD = "Add new author";
	public static final String AUTHOR_MENU_UPDATE = "Update author entry";
	public static final String AUTHOR_MENU_DELETE = "Delete author entry";
	public static final String AUTHOR_MENU_ASSIGN_BOOK = "Assign author to book";
	public static final String AUTHOR_MENU_UNASSIGN_BOOK = "Unassign author to book";
	public static final String[] AUTHOR_MENU_OPTIONS = new String[]{AUTHOR_MENU_FIND_BY_ID,
			AUTHOR_MENU_FIND_BY_NAME, AUTHOR_MENU_FIND_BY_BOOK_TITLE, AUTHOR_MENU_ADD,
			AUTHOR_MENU_UPDATE, AUTHOR_MENU_DELETE, AUTHOR_MENU_ASSIGN_BOOK, AUTHOR_MENU_UNASSIGN_BOOK};

	public static final String GENRE_MENU_GET_BY_ID = "Get genre by ID";
	public static final String GENRE_MENU_GET_BY_NAME = "Get genre by name";
	public static final String GENRE_MENU_CREATE = "Add new genre";
	public static final String GENRE_MENU_UPDATE = "Update genre entry";
	public static final String GENRE_MENU_DELETE = "Delete genre entry";
	public static final String GENRE_MENU_ASSIGN_BOOK = "Assign genre to book";
	public static final String GENRE_MENU_UNASSIGN_BOOK = "Unassign genre to book";
	public static final String[] GENRE_MENU_OPTIONS = {GENRE_MENU_GET_BY_ID, GENRE_MENU_GET_BY_NAME,
			GENRE_MENU_CREATE, GENRE_MENU_UPDATE, GENRE_MENU_DELETE, GENRE_MENU_ASSIGN_BOOK, GENRE_MENU_UNASSIGN_BOOK};

	public static final String SERIES_MENU_GET_BY_ID = "Get series by ID";
	public static final String SERIES_MENU_GET_BY_NAME = "Get series by name";
	public static final String SERIES_MENU_CREATE = "Add new series";
	public static final String SERIES_MENU_UPDATE = "Update series entry";
	public static final String SERIES_MENU_DELETE = "Delete series entry";
	public static final String SERIES_MENU_ADD_BOOK = "Assign book to series";
	public static final String SERIES_MENU_REMOVE_BOOK = "Unassign book to series";
	private static final String[] SERIES_MENU_OPTIONS = {SERIES_MENU_GET_BY_ID, SERIES_MENU_GET_BY_NAME, SERIES_MENU_CREATE,
			SERIES_MENU_UPDATE, SERIES_MENU_DELETE, SERIES_MENU_ADD_BOOK, SERIES_MENU_REMOVE_BOOK};

}
