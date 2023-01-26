package org.example;

import org.apache.commons.dbcp2.BasicDataSource;
import org.example.dao.*;
import org.example.view.Menu;

import javax.sql.DataSource;
import org.example.view.MenuConstants;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.sql.SQLOutput;
import java.util.Scanner;

import static org.example.view.MenuConstants.*;

public class BookProjectCLI {



	private final Menu menu;
	private final AuthorDao authorDao;
	private final BookDao bookDao;
	private final SeriesDao seriesDao;
	private final GenreDao genreDao;
	public static BookProjectCLI application;

	public Menu getMenu() {
		return menu;
	}

	public AuthorDao getAuthorDao() {
		return authorDao;
	}

	public BookDao getBookDao() {
		return bookDao;
	}

	public SeriesDao getSeriesDao() {
		return seriesDao;
	}

	public GenreDao getGenreDao() {
		return genreDao;
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/bookproject");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");

		application = new BookProjectCLI(dataSource);
		application.run();

	}

	public BookProjectCLI(DataSource dataSource) {
		this.menu = new Menu(System.in, System.out);

		authorDao = new JdbcAuthorDao(dataSource);
		bookDao = new JdbcBookDao(dataSource);
		seriesDao = new JdbcSeriesDao(dataSource);
		genreDao = new JdbcGenreDao(dataSource);


	}

	private void run(){
		System.out.println("VIRTUAL LIBRARY CATALOGUE" + System.lineSeparator());


		while(true){
			String userChoice = menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if(userChoice.equals(MAIN_MENU_BOOKS)){
				String menuChoice = menu.getChoiceFromOptions(BOOK_MENU_OPTIONS);
				if (menuChoice.equals(BOOK_MENU_FIND_BY_ID)){
					menu.getBookById();
				}
			}
		}
	}
}