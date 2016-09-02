package com.beerzoo;

public class Beer {

	private int beerID = 0;
	private String beerName = null;
	private String countryOfOrigin = null;
	private String style = null;
	private double aBV = 0.0;
	
	
	public Beer() {
		super();
	} //beer constructor


	public int getBeerID() {
		return beerID;
	}


	public void setBeerID(int beerID) {
		this.beerID = beerID;
	}


	public String getBeerName() {
		return beerName;
	}


	public void setBeerName(String beerName) {
		this.beerName = beerName;
	}


	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}


	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}


	public String getStyle() {
		return style;
	}


	public void setStyle(String style) {
		this.style = style;
	}


	public double getAbv() {
		return aBV;
	}


	public void setAbv(double abv) {
		this.aBV = abv;
	}


	@Override
	public String toString() {
		return "Beer [beerID=" + beerID + ", beerName=" + beerName + ", countryOfOrigin=" + countryOfOrigin + ", style="
				+ style + ", abv=" + aBV + "]";
	}



	
	
	
	
	
	
} //class
