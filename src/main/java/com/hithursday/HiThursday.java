package com.hithursday;

import java.util.Scanner;

public class HiThursday {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String userMenuInput = null;
		boolean menuCorrect = false;
		
		System.out.println("Welcome t the student info program.");
		
		
		do {
			System.out.println("Press one to read the database");
			System.out.println("Press two to add to the database");
			userMenuInput = sc.nextLine();
			switch (userMenuInput) {
			case "1":
				DAO.readFromDB();
				
				break;
			case "2":
				DAO.writeToDB();
				break;

			default:
				System.out.println("You've entered and invalid option");
				menuCorrect = true;
				break;
			}
		} while (menuCorrect);
		
	}

}
