package com.regapp.model;
import java.sql.*;
public class DAOServiceImpl implements DAOService {

	// for connection to DB
	private Connection con;
	private Statement stmnt;
	
	@Override
	public void connectDB() {
	// to connect the Data base
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // for Driver Class
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_page" , "root" , "root");
			stmnt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	@Override
	public boolean verifyCredentials(String email, String password) {
	// check for email , password
		try {
			ResultSet result = stmnt.executeQuery("SELECT * FROM login WHERE email = '"+email+"' and password='"+password+"'");
			return result.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false; //if any exception it will return false
	}

	@Override
	public void saveRegistration(String name, String city, String email, String mobile) {
	// this method will help us to save the new data in database
		try {
			stmnt.executeUpdate("INSERT INTO registration VALUES('"+name+"' , '"+city+"' , '"+email+"' , '"+mobile+"')");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public ResultSet getAllReg() {
	// this method is for get all the data from registration table
		try {
			ResultSet result = stmnt.executeQuery("SELECT * FROM registration");
			return result;
			// it will print all the data from registration table 
		} catch (Exception e) {
			e.printStackTrace(); // if any exception
		}
		return null; // it will print null
	}

	@Override
	public void deleteByEmail(String email) {
	// delete the record using email
		try {
			stmnt.executeUpdate(" DELETE FROM registration WHERE email='"+email+"' ");
			// it will delete the record from the registration table
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void updateReg(String email, String mobile) {
	// for update the mobile using email
		try {
			stmnt.executeUpdate(" UPDATE registration SET mobile='"+mobile+"' WHERE email='"+email+"' ");
			// it will update the mobile using email
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
