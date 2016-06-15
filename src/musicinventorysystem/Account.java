package musicinventorysystem;

/* TABLE OF CONTENTS (Use ctrl+f to navigate, case sensitive)
 * 
 * 1- VARIABLES
 * 2- CONSTRUCTORS
 * 3- GETTER METHODS
 * 4- OTHER METHODS
 */

/**A class to hold basic information about the currently logged in user.
 * @author Erica Garand*/
public class Account implements Comparable {
	
	///////////////////////
	////// VARIABLES //////
	///////////////////////
	
	/**A string. The first name of the account holder*/
	private String fname;
	/**A string. The last name of the account holder*/
	private String lname;

	/**A string. The username of the account holder.*/
	private String uname;
	
	/**A string. the password of the account holder.*/
	private String pword;

	/**A boolean. True is the user has admin privileges, False if they're a regular user. Note that this wouldn't
	be an option at registration or anything; the one admin profile to rule them all would have to be manually assigned
	an admin through one of us editing the database.*/
	private boolean admin;
	/**A boolean. True if the user has an instrument currently signed out. False if they do not.*/
	private boolean isUsingInstrument;
        
	/**Creates a new account object using the built in openNewUser() method.
=======
	//////////////////////////
	////// CONSTRUCTORS //////
	//////////////////////////

	/**Creates a new account object.
>>>>>>> origin/master
	@param fname - the first name of the logged in user
	@param lname - the last name of the logged in user
	@param admin - whether or not the logged in user has admin priveliges
	@param isUsingInstrument - whether or not the logged in user already as an instrument signed out*/
	public Account(String uname, String pword, String fname, String lname, boolean admin, boolean isUsingInstrument){
		this.fname = fname;
		this.lname = lname;
		this.uname = uname;
		this.pword = pword;
		this.admin = admin;
		this.isUsingInstrument = isUsingInstrument;
	}

	
	////////////////////////////
	////// GETTER METHODS //////
	////////////////////////////
	
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
	/**@return The username of the account holder*/
	public String getUsername(){
		return uname;
	}
	/**@return The password of the account holder*/
	public String getPassword(){
		return pword;
	}

	/**@return the full name and admin status of the account holder as a string.*/
	public String toString(){
		return fname + " " + lname + " - Admin: " + admin;
	}

	
	///////////////////////////
	////// OTHER METHODS //////
	///////////////////////////
		
	/**Compares two accounts. If both the username and the password match, the accounts match. Otherwise, just the
	 * usernames are compared to see which Account is "less" or "greater". Default case is less than.
	 * @param o - The Account object to compare to this one.*/
	public int compareTo(Object o) {
		if (o.getClass() != Account.class)
			throw new IllegalArgumentException("You cannot compare any random object to an Account.");
		Account a = (Account)o;
		
		if (this.getUsername().equals(a.getUsername()) == true && this.getPassword().equals(a.getPassword()) == true)
			return 0;
		else if (this.getUsername().compareTo(a.getUsername) < 0)
			return -1;
		else if (this.getUsername().compareTo(a.getUsername) > 0)
			return 1;
		else
			return -1;
	}
	
	
}
