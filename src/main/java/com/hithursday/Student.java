package com.hithursday;

public class Student {
	
	public String studentID = null;
	public String lastName = null;
	public String firstName = null;
	public double gpa = 0.0;
	
	public Student(){
		super();
		
			}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
public String toString() {
    return "Students [studentID=" + studentID + ", lastName=" + lastName + ", firstName=" + firstName + ", gpa="
            + gpa + "]";
}
}