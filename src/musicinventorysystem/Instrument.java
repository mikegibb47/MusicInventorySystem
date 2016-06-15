package musicinventorysystem;

import java.util.Arrays;
import java.util.List;

/* TABLE OF CONTENTS (Use ctrl+f to navigate, case sensitive)
 * 
 * 1- CONSTANTS
 * 2- VARIABLES
 * 3- CONSTRUCTORS
 * 4- GETTER METHODS
 * 5- SETTER METHODS
 */

/**A class to hold basic information about an instrument.
 @author Erica Garand*/
public class Instrument implements Comparable {

	////// CONSTANTS //////

	/**A string that is to be used to signify that an instrument is out for service.*/
	public static final String OUT_FOR_SERVICE = "Out For Service";


	///////////////////////
	////// VARIABLES //////
	///////////////////////

	/**A string that holds the name of the instrument, ex "Clarinet" or "Trumpet".*/
	private String name;

	/**A string. If the instrument is available, this string should be empty. If the instrument has been
	signed out by someone, this string will contain that person's username. If the instrument is out for service,
	it will contain the string represented by the public static constant Instrument.OUT_FOR_SERVICE.
	@see Instrument.OUT_FOR_SERVICE*/
	private String curUser;

	/**A barcode that acts as a unique identifier for each individual instrument.*/
	private String id;

	/**A boolean value tracking whether the instrument is in or out. True if it's ready to go,
	False if it's been signed out or if it's out for service.*/
	private boolean isAvailable;

	/**A List of Strings. This will contain the usernames of every person who has ever signed out
	this instrument. The first person who ever signed it out will be the first person in the list. The most
	recent person who used it will be the last person in the list.
	@see java.util.List*/
	private List<String> userHist;


	///////////////////////////
	/////// CONSTRUCTORS //////
	///////////////////////////

	/**Creates a new instrument object with all the necessary variables.
	@param name - the name of the instrument, ex "Clarinet" or "Trumpet".
	@param id - A barcode that acts as a unique identifier for each individual instrument.
	@param isAvailable - A boolean value tracking whether the instrument is in or out. True if it's ready to go,
	False if it's been signed out or if it's out for service.
	@param curUser - If the instrument is available, this string should be empty. If the instrument has been
	signed out by someone, this string will contain that student's name. If the instrument is out for service,
	it will contain the string represented by the public static constant Instrument.OUT_FOR_SERVICE.
	@param userHist - a single string containing the USERNAMES of all the people who have used this instrument in
	the past, delimited by commas.*/
	public Instrument(String name, String id, boolean isAvailable, String curUser, String userHist){
		this.name = name;
		this.id = id;
		this.isAvailable = isAvailable;
		this.curUser = curUser;
		this.userHist = Arrays.asList(userHist.split(","));
	}


	////////////////////////////
	////// GETTER METHODS //////
	////////////////////////////

	/**@return True if the instrument is available, False if it's been signed out or if it's out for service.*/
	public boolean isAvailable(){
		return isAvailable;
	}
	
	/**@return the username of the person who has this instrument signed out, if anyone has. Empty if there is no user, equal to
	Instrument.OUT_FOR_SERVICE is the instrument is being serviced, and containing a name if someone has it
	signed out.*/
	public String getCurrentUser(){
		return curUser;
	}
	
	/**@return the unique barcode of this instrument*/
	public String getID(){
		return id;
	}
	
	/**@return the name and id (unique identifier) of the instrument, followed by whoever is using it, if anyone.*/
	public String toString(){
		return String.format("%s%10d%25s", name, id, curUser);
	}
	
	
	/////////////////////////////
	////// SETTER METHODS ///////
	/////////////////////////////

	/**Allows the instrument to be signed out. This registers the name of whoever is signing it out and marks
	the instrument as unavailable.*/
	public void signOut(String user){
		if (isAvailable == true){
			curUser = user;
			isAvailable = false;
		}
	}
	
	/**Allows the instrument to be signed back in. This clears the name of the current user and marks the
	instrument as available.*/
	public void signIn(){
		if (isAvailable = false){
			curUser = "";
			isAvailable = true;
		}
	}
	
	/**Allows the instrument to be signed out for service specifically. This registers the name the current
	user as the special service string constant and marks the instrument as unavailable. Functionally the same as
	signOut(Instrument.OUT_FOR_SERVICE)*/
	public void service(){
		if (isAvailable = true){
			curUser = Instrument.OUT_FOR_SERVICE;
			isAvailable = false;
		}
	}
	
	
	///////////////////////////
	////// OTHER METHODS //////
	///////////////////////////
	
	/**Compares two instruments using their id strings, aka their barcodes. If the instruments are read in properly
	 * then no two instruments should ever share a barcode, and thus this method should never return 0...*/
	public int compareTo(Object o) {
		if (o.getClass() != Instrument.class)
			throw new IllegalArgumentException("You cannot compare any random object to an Instrument.");
		Instrument a = (Instrument)o;
		
		return (this.getID().compareTo(a.getID()))
	}

}
