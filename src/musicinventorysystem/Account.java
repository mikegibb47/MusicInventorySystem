package musicinventorysystem;

public class Account {
	/**A string. The first name of the account holder*/
	private String fname;
	/**A string. The last name of the account holder*/
	private String lname;
	/**A boolean. True is the user has admin privileges, False if they're a regular user. Note that this wouldn't
	be an option at registration or anything; the one admin profile to rule them all would have to be manually assigned
	an admin through one of us editing the database.*/
	private boolean admin;
	/**A boolean. True if the user has an instrument currently signed out. False if they do not.*/
	private boolean isUsingInstrument;
	
	/**Creates a new account object using the built in openNewUser() method.
	@param fname - the first name of the logged in user
	@param lname - the last name of the logged in user
	@param admin - whether or not the logged in user has admin priveliges
	@param isUsingInstrument - whether or not the logged in user already as an instrument signed out*/
	public Account(String fname, String lname, boolean admin, boolean isUsingInstrument){
		openNewUser(fname, lname, admin, isUsingInstrument);
	}
	
	/**Allows the account object to be reused by reassigning all the object's parameters.
	@param fname - the first name of the logged in user
	@param lname - the last name of the logged in user
	@param admin - whether or not the logged in user has admin priveliges
	@param isUsingInstrument - whether or not the logged in user already as an instrument signed out*/
	public void openNewUser(String fname, String lname, boolean admin, boolean isUsingInstrument){
		this.fname = fname;
		this.lname = lname;
		this.admin = admin;
		this.isUsingInstrument = isUsingInstrument;
	}
	
	/**@return True is the user has admin privileges, False if they're a regular user.*/
	public boolean isAdmin(){
		return admin;
	}
	/**@return True if the user has an instrument currently signed out. False if they do not.*/
	public boolean isUsingInstrument(){
		return isUsingInstrument;
	}
	/**@return The first name of the account holder*/
	public String getFirstName(){
		return fname;
	}
	/**@return The last name of the account holder*/
	public String getLastName(){
		return lname;
	}
	
	/**@return the full name and admin status of the account holder as a string.*/
	public String toString(){
		return fname + " " + lname + " - Admin: " + admin;
	}

}
