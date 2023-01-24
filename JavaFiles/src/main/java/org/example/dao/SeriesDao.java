package org.example.dao;

import org.example.models.Series;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.List;
public interface SeriesDao {

	Series getSeries(int SeriesId);

	List<Series> getSeriesByName(String name);

	Series createSeries(Series series);

	void updateSeries(Series updatedSeries);

	void deleteSeries(int seriesId);

	void addSeriesToBook(int seriesId);

	void removeSeriesFromBook(int bookId);

	Series mapRowToSeries(SqlRowSet rowSet);
}
