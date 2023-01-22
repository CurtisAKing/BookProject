package org.example.models;

public class Series {
	private int seriesID;
	private String seriesName;

	public Series(String seriesName) {
		this.seriesName = seriesName;
	}

	public int getSeriesID() {
		return seriesID;
	}

	public void setSeriesID(int seriesID) {
		this.seriesID = seriesID;
	}

	public String getSeriesName() {
		return seriesName;
	}

	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}
}
