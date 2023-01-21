DROP TABLE IF EXISTS author_books;
DROP TABLE IF EXISTS genre_books;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS author;
DROP TABLE IF EXISTS series;
DROP TABLE IF EXISTS genre;

CREATE TABLE series(
	series_id serial,
	series_name VARCHAR(70) NOT NULL,
	CONSTRAINT pk_series_id PRIMARY KEY (series_id)
);

CREATE TABLE book(
	book_id serial,
	series_id int,
	title VARCHAR(70) NOT NULL,
	has_audiobook boolean,
	rating numeric(3,2),
	CONSTRAINT pk_book_id PRIMARY KEY(book_id),
	CONSTRAINT fk_series_id FOREIGN KEY (series_id) REFERENCES series(series_id)
);

CREATE TABLE author(
	author_id serial,
	name VARCHAR(50) NOT NULL,
	birthday date,
	birth_place VARCHAR(50),
	CONSTRAINT pk_author_id PRIMARY KEY (author_id)
);

CREATE TABLE author_books(
	book_id int NOT NULL,
	author_id int NOT NULL,
	CONSTRAINT pk_book_id_author_id PRIMARY KEY(book_id, author_id),
	CONSTRAINT fk_ab_book_id FOREIGN KEY(book_id) REFERENCES book(book_id),
	CONSTRAINT fk_ab_author_id FOREIGN KEY(author_id) REFERENCES author(author_id)
);



CREATE TABLE genre(
	genre_id serial,
	genre_name VARCHAR(25),
	CONSTRAINT pk_genre_id PRIMARY KEY (genre_id)
);

CREATE TABLE genre_books(
	genre_id int NOT NULL,
	book_id int NOT NULL,
	CONSTRAINT pk_genre_id_book_id PRIMARY KEY (genre_id, book_id),
	CONSTRAINT fk_genre_id FOREIGN KEY (genre_id) REFERENCES genre(genre_id),
	CONSTRAINT fk_book_id FOREIGN KEY (book_id) REFERENCES book(book_id)
);