package org.example.view;

import org.example.BookProjectCLI;
import org.example.dao.JdbcBookDao;
import org.example.models.*;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import static org.example.BookProjectCLI.application;

public class Menu {
	private final PrintWriter out;
	private final Scanner in;

	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}

	public String getChoiceFromOptions(String[] options) {
		String choice = null;
		while (choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}

	public void displayMenuOptions(String[] options) {
		for (int i = 0; i < options.length; i++) {
			int optionNumber = i + 1;
			out.println(optionNumber + ") " + options[i]);
		}
		out.print(System.lineSeparator() + "Please make a selection: ");
		out.flush();
	}

	private String getChoiceFromUserInput(String[] options) {
		String choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch (NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if (choice == null) {
			out.println(System.lineSeparator() + "*** " + userInput + " is not a valid option ***" + System.lineSeparator());
		}
		return choice;
	}

	public void getBookById() {
		System.out.println("\nPlease enter the book ID: ");
		String bookId = in.nextLine();

		int bookID = Integer.parseInt(bookId);
		Book book = application.getBookDao().getBook(bookID);
	}
}

