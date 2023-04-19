package com.regapp.model;

import java.sql.ResultSet;

public interface DAOService {
	
	public void connectDB();
	// to connect the Data base
	
	public boolean verifyCredentials(String email , String password);
	/* check for email , password
	 * 		TRUE --> credentials are valid
	 * 		FALSE --> for invalid
	*/
	
	public void saveRegistration(String name  , String city , String email , String mobile);
	// this method will help us to save the new data in database
	
	public ResultSet getAllReg();
	// this method is for get all the data from registration table
	
	public void deleteByEmail(String email);
	// delete the record using email 

	public void updateReg(String email, String mobile);
	// for update the mobile using email
}
