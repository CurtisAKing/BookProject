package org.example.dao;

import org.example.models.Series;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcSeriesDao implements SeriesDao{

	private final JdbcTemplate jdbcTemplate;

	public JdbcSeriesDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Series getSeries(int seriesId) {
		Series series = null;
		String sqlGetSeries = "SELECT series_id, series_name FROM series WHERE series_id = ?;";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlGetSeries, seriesId);
		if (result.next()){
			series = mapRowToSeries(result);
		}
		return series;
	}

	@Override
	public List<Series> getSeriesByName(String name) {
		List<Series> seriesList = new ArrayList<>();
		String sqlGetSeriesByName = "SELECT series_id, series_name FROM series WHERE series_name = ?;";
		String nameSearch = "%" + name + "%";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlGetSeriesByName, name);
		if(result.next()){
			seriesList.add(mapRowToSeries(result));
		}
		if(seriesList.isEmpty()){
			result = jdbcTemplate.queryForRowSet(sqlGetSeriesByName, nameSearch);
			seriesList.add(mapRowToSeries(result));
		}
		return seriesList;
	}

	@Override
	public Series createSeries(Series series) {
		String sqlCreate = "INSERT INTO series (series_name) VALUES (?) RETURNING series_id;";
		series.setSeriesID(jdbcTemplate.update(sqlCreate, series.getSeriesName()));
		return series;
	}

	@Override
	public void updateSeries(Series updatedSeries) {
		String sqlUpdate = "UPDATE series SET series_name = ? WHERE series_id = ?;";
		jdbcTemplate.update(sqlUpdate, updatedSeries.getSeriesID());
	}

	@Override
	public void deleteSeries(int seriesId) {
		String sqlDelete = "DELETE FROM series_books WHERE series_id = ?; " +
				"DELETE FROM series WHERE series_id = ?;";
		jdbcTemplate.update(sqlDelete, seriesId, seriesId);
	}

	@Override
	public void addSeriesToBook(int seriesId, int bookId) {
		String sqlAdd = "INSERT INTO series_books (series_id, book_id) VALUES (?,?);";
		jdbcTemplate.update(sqlAdd, seriesId, bookId);
	}

	@Override
	public void removeSeriesFromBook(int seriesId, int bookID) {
		String sqlRemove = "DELETE FROM series_books WHERE series_id = ? AND book_id = ?;";
		jdbcTemplate.update(sqlRemove, seriesId, bookID);
	}

	@Override
	public Series mapRowToSeries(SqlRowSet rowSet) {
		Series series = new Series();
		series.setSeriesID(rowSet.getInt("series_id"));
		series.setSeriesName(rowSet.getString("series_name"));
		return series;
	}
}
