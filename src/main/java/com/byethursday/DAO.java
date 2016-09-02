package com.byethursday;

import java.sql.*;
import java.util.ArrayList;

public class DAO {
	
	static final String DB_URL= "jdbc:mysql://127.0.0.1:3306/?user=root&autoReconnect=true&useSSL=false";
	static final String USER = "root";
	static final String PASSWORD = "sesame";

	static Connection CONN = null;
	static Statement STMT = null;
	static PreparedStatement PREP_STMT = null;
	static ResultSet RES_SET= null;
	
	public static void connToDB(){
		
		try {
			System.out.println("Trying to connect to the Database...");
			CONN=DriverManager.getConnection(DB_URL, USER, PASSWORD);
			System.out.println("Connected to the database.");
		} catch (SQLException e) {
			System.out.println("Failed to connect to the database.");
			e.printStackTrace();
		}
	}

	public static void readFromDB(){
		
		connToDB();
		ArrayList<Student> ourStudents = new ArrayList<>();
		
		try{
			STMT = CONN.createStatement();
			RES_SET= STMT.executeQuery("SELECT * FROM student.student");
			
			while(RES_SET.next()){
				Student studentDB = new Student();
				studentDB.setStudentID(RES_SET.getString("student_id"));
				studentDB.setLastName(RES_SET.getString("last_name"));
				studentDB.setFirstName(RES_SET.getString("first_name"));
				studentDB.setGpa(RES_SET.getDouble("GPA"));
				
				ourStudents.add(studentDB);
				
			}
			
			for (Student student : ourStudents) {
				System.out.println(student.toString());
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
} //class
