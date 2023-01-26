package org.example;

import org.apache.commons.dbcp2.BasicDataSource;
import org.example.dao.*;
import org.example.view.Menu;

import javax.sql.DataSource;
import org.example.view.MenuConstants;

import static org.example.view.MenuConstants.*;

public class BookProjectCLI {



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



		this.authorDao = new JdbcAuthorDao(dataSource);
		this.bookDao = new JdbcBookDao(dataSource);
		this.seriesDao = new JdbcSeriesDao(dataSource);
		this.genreDao = new JdbcGenreDao(dataSource);
	}

	private void run(){
		System.out.println("Hello");
	}
}