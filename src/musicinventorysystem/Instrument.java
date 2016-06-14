package musicinventorysystem;

import java.util.Arrays;
import java.util.List;

public class Instrument {
	public static final String OUT_FOR_SERVICE = "Out For Service";
	
	/**A string that holds the name of the instrument, ex "Clarinet" or "Trumpet".*/
	private String name;
	/**A string. If the instrument is available, this string should be empty. If the instrument has been
	signed out by someone, this string will contain that student's name. If the instrument is out for service,
	it will contain the string represented by the public static constant Instrument.OUT_FOR_SERVICE.
	@see Instrument.OUT_FOR_SERVICE*/
	private String curUser;
	/**A barcode that acts as a unique identifier for each individual instrument.*/
	private String id;
	/**A boolean value tracking whether the instrument is in or out. True if it's ready to go,
	False if it's been signed out or if it's out for service.*/
	private boolean isAvailable;
	/**A List of Strings. This will contain the names of every person who has ever signed out
	this instrument. The first person who ever signed it out will be the first person in the list. The most
	recent person who used it will be the last person in the list.
	@see java.util.List*/
	private List<String> userHist;
	
	/**Creates a new instrument object with all the necessary variables.
	@param name - the name of the instrument, ex "Clarinet" or "Trumpet".
	@param id - A barcode that acts as a unique identifier for each individual instrument.
	@param isAvailable - A boolean value tracking whether the instrument is in or out. True if it's ready to go,
	False if it's been signed out or if it's out for service.
	@param curUser - If the instrument is available, this string should be empty. If the instrument has been
	signed out by someone, this string will contain that student's name. If the instrument is out for service,
	it will contain the string represented by the public static constant Instrument.OUT_FOR_SERVICE.
	@param userHist - a single string containing the names of all the people who have used this instrument in
	the past, delimited by commas.*/
	public Instrument(String name, String id, boolean isAvailable, String curUser, String userHist){
		this.name = name;
		this.id = id;
		this.isAvailable = isAvailable;
		this.curUser = curUser;
		this.userHist = Arrays.asList(userHist.split(","));
	}
	
	/**@return True if the instrument is available, False if it's been signed out or if it's out for service.*/
	public boolean isAvailable(){
		return isAvailable;
	}
	/**@return the person who has this instrument signed out, if anyone has. Empty if there is no user, equal to
	Instrument.OUT_FOR_SERVICE is the instrument is being serviced, and containing a name if someone has it
	signed out.*/
	public String getCurrentUser(){
		return curUser;
	}
        /**@return the unique barcode of this instrument*/
        public String getID(){
            return id;
        }
	
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
	
	
	/**@return the name and id (unique identifier) of the instrument, followed by whoever is using it, if anyone.*/
	public String toString(){
		return String.format("%s%10d%25s", name, id, curUser);
	}
	
}
