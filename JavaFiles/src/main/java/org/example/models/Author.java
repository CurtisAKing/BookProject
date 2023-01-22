package org.example.models;

import java.time.LocalDate;

public class Author {
	private int authorId;
	private String name;
	private LocalDate birthday;
	private String birthplace;

	public Author(String name, LocalDate birthday, String birthplace) {
		this.name = name;
		this.birthday = birthday;
		this.birthplace = birthplace;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}
}
