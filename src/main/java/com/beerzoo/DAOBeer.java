package com.beerzoo;

import java.sql.*;
import java.util.ArrayList;

import com.beerzoo.Beer;

public class DAOBeer {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/?user=root&autoReconnect=true&useSSL=false";
	static final String USER = "root";
	static final String PASSWORD = "sesame";

	static Connection CONN = null;
	static Statement STMT = null;
	static PreparedStatement PREP_STMT = null;
	static ResultSet RES_SET = null;

	public static ArrayList<Beer> ourBeers = new ArrayList<>();

	public static void connToDB() {

		try {
			Class.forName(JDBC_DRIVER);

			System.out.println("Trying to connect to the Database...");
			CONN = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			System.out.println("Connected to the database.");
		} catch (Exception e) {
			System.out.println("Failed to connect to the database.");
			e.printStackTrace();
		}
	}  //connToDB
	
	public static void readFromDB(){
		
		connToDB();
		
		
		try{
			STMT = CONN.createStatement();
			RES_SET= STMT.executeQuery("SELECT * FROM beer_schema.beer_zoo;");
			
			while(RES_SET.next()){
				Beer beerInDB = new Beer();
				beerInDB.setBeerID(RES_SET.getInt("beer_id"));
				beerInDB.setBeerName(RES_SET.getString("name"));
				beerInDB.setCountryOfOrigin(RES_SET.getString("country_of_origin"));
				beerInDB.setStyle(RES_SET.getString("style"));
				beerInDB.setAbv(RES_SET.getDouble("abv"));
				
				ourBeers.add(beerInDB);
				
			}
			
			for (Beer beer : ourBeers) {
				System.out.println(beer.toString());
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
	} //connToDB
	
	public static void writeToDB(Beer beer){
		
		connToDB();
		
		try {
			PREP_STMT = CONN.prepareStatement(insertToDB);
			
			PREP_STMT.setString(1, beer.getBeerName());
			
			PREP_STMT.setString(2, beer.getCountryOfOrigin());
			
			PREP_STMT.setString(3, beer.getStyle());
			
			PREP_STMT.setDouble(4, beer.getAbv());
			
			PREP_STMT.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} //writeToDB method
	
	private static String insertToDB = "INSERT INTO `beer_schema`.`beer_zoo`"
			+ "(name, country_of_origin, style, abv)"
			+ "VALUES"
			+ "(?, ?, ?, ?)";
	
	public static void deleteFromDB(Beer toRemove){
		
		connToDB();
		
		try{
		PREP_STMT = CONN.prepareStatement(deleteFromDB);
		PREP_STMT.setInt(1, toRemove.getBeerID());
		PREP_STMT.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} //deleteFromDB
		
	private static String deleteFromDB = "DELETE FROM `beer_schema`.`beer_zoo`"
			+ "WHERE beer_id=?";
	
	private static String updateBeer = "UPDATE `beer_schema`.`beer_zoo` SET"
			+ " beer_id = ?,"
			+ " name = ?,"
			+ "country_of_origin = ?,"
			+ "style = ?,"
			+ "abv = ?"
			+ "WHERE beer_id = ?";
			

	public static void updateBeerZoo(Beer beer){
		
		connToDB();
		
		try {
			PREP_STMT = CONN.prepareStatement(updateBeer);
			
			PREP_STMT.setInt(1, beer.getBeerID());
			PREP_STMT.setString(2, beer.getBeerName());
			PREP_STMT.setString(3, beer.getCountryOfOrigin());
			PREP_STMT.setString(4, beer.getStyle());
			PREP_STMT.setDouble(5, beer.getAbv());
			PREP_STMT.setInt(6, beer.getBeerID());
			
			
			
			PREP_STMT.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}  //class
