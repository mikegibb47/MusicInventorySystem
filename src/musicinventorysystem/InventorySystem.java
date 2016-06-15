package musicinventorysystem;

import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Array;
import java.util.Collections;

/* TABLE OF CONTENTS (Use ctrl+f to navigate, case sensitive)
 * 
 * 1- VARIABLES
 * 2- CONSTRUCTORS
 * 3- GETTER METHODS
 * 4- SETTER METHODS
 * 5- OTHER METHODS
 */

/**A class that holds the inventory data in memory and manipulates it as needed.
 * @author Erica Garand*/
public class InventorySystem {

	///////////////////////
	////// VARIABLES //////
	///////////////////////

	/**A number that points to the spot in the user list that contains the information of the currently logged in user.*/
	private int currentUser;
	
	/**A list that holds the information of all registered users in memory.*/
	private List<Account> users;
	
	/**A list that holds the information of all registered instruments in memory.*/
	private List<Instrument> instruments;

	
	//////////////////////////
	////// CONSTRUCTORS //////
	//////////////////////////
	
	public InventorySystem() {
		users = new ArrayList<Account>();
		instruments = new ArrayList<Instrument>();

		// BELOW IS DUMMY DATA, FOR TESTING ONLY. The files will have to be read from to get the real data.
		instruments.add(new Instrument("Clarinet", "4", true, "", "Bilbo Baggins,Corrin of Nohr"));
		instruments.add(new Instrument("Trumpet", "2", true, "", ""));
		instruments.add(new Instrument("Trombone", "3", false, "John Doe", "Bilbo Baggins,John Doe"));
		instruments.add(new Instrument("Cow Bell", "1", false, Instrument.OUT_FOR_SERVICE, ""));
		
		users.add(new Account("Bilbo", "Baggins", "ahobbit", "arkenstone", false, false));
		users.add(new Account("Corrin", "of Nohr", "yatomaster", "anankos", false, false));
		users.add(new Account("John", "Doe", "mysteryman", "whoami", false, true));
		users.add(new Account("TheMighty", "AdminGuy", "rulerofall","sauron", true, false));
		
		instruments = bubbleSort((List) instruments);
		users = bubbleSort((List)users);
                
                for (int i = 0; i < instruments.size();i++)
                    System.out.println(instruments.get(i));

	}
	
	
	////////////////////////////
	////// GETTER METHODS //////
	////////////////////////////
	
	/**Used to retrieve a list of all the instruments a specific student has used in the past.
	 * @author Erica Garand*/
	public List<Instrument> getStudentSignoutHistory(){
		return null;
	}

	/**Used to retrieve a list of all the users currently used.
	 * @author Erica Garand*/
	public List<Account> getUserList(){
		return users;
	}

	/**Used to retrieve a list of all the users currently used.
	 * @author Erica Garand*/
	public Account getLoggedInUser(){
		if( currentUser >= 0 && currentUser <users.size() )
			return users.get(currentUser);
		return null;
	}
	
	
	////////////////////////////
	////// SETTER METHODS //////
	////////////////////////////
	
	/**Allows a new user to be added to the file.
	 * @author Erica Garand
     * @param u - The Account object to be added to the list. Should be newly created, as
     * Account objects are largely unchangeable once created. */
	public void addUser(Account u){
		//stuff
	}

	/**Allows an admin profile to manually remove a user from the user file, if necessary.
	 * @author Erica Garand*/
	public void removeUser(Account u){
		if( currentUser >= 0 && currentUser < users.size() && users.get(currentUser).isAdmin() == true ){
			//stuff
		}
	}

	/**Allows an admin profile to manually add an instrument to the file.
	 * @author Erica Garand*/
	public void addInstrument(Instrument a){
		if( currentUser >= 0 && currentUser < users.size() && users.get(currentUser).isAdmin() == true ){
			instruments.add(a);
		}
	}

	/**Allows an admin profile to manually remove an Instrument from the file.
	 * @author Erica Garand*/
	public void removeInstrument(String barcode){
		if( currentUser >= 0 && currentUser < users.size() && users.get(currentUser).isAdmin() == true ){
			//stuff
		}
	}

	/**Allows an admin profile to indicate whether or not an instrument is out for service.
	 * @author Erica Garand*/
	public void serviceAnInstrument(String barcode){
		if( currentUser >= 0 && currentUser < users.size() && users.get(currentUser).isAdmin() == true ){
			//stuff
		}
	}

	/**Allows any profile to sign out an instrument.
	 * @author Erica Garand*/
	public void signOutInstrument(String barcode){
		if( currentUser >= 0 && currentUser < users.size() ){
			//stuff
		}
	}

	/**Allows any profile to sign back in an instrument.
	 * @author Erica Garand*/
	public void signInInstrument(String barcode){
		if( currentUser >= 0 && currentUser < users.size() ){
			//stuff
		}
	}
	
	/**Used to log in a user to the program.
	 * @author Erica Garand
	 * @param user - The username of the user trying to log in.
	 * @param pass - The password of the user trying to log in.*/
	public void logIn(String user, String pass){
		Account temp = new Account("","",user,pass,false,false);
		
		//search through all the accounts
		int index = binarySearch(temp, (List)users);
		
		//if a matching account it found, set currentUser to point to that account
		if (index >= 0)
			currentUser = index;
		//if no matching account was found, throw an exception
		else
			System.out.println("Put exception throwing stuff here");
	}

	/**Used to log out the user currently using the program.
	 * @author Erica Garand*/
	public void logOut(){
		//set currentUser to -1, so it points to no account
		currentUser = -1;
	}
	
	
	///////////////////////////
	////// OTHER METHODS //////
	///////////////////////////

	/**
	 * Sorts an unsorted array of objects which implement the comparable
	 * interface using the bubble-sort algorithm
	 *
	 * @param unsorted - the array of comparable objects to be sorted
	 * @author Matthew Gulbronson
	 */
	public List<Comparable> bubbleSort(List<Comparable> unsorted) {
		boolean swapped;
		do {
			swapped = false;
			for (int i = 0; i < unsorted.size() - 1; i++) {
				if (unsorted.get(i).compareTo(unsorted.get(i+1)) > 0) {
                                    Collections.swap(unsorted, i, i+1);
                                    swapped = true;
				}
			}
		} while (swapped);
		
		return unsorted;
	}
	
	/**Does a binary search for an item in an array of items, then returns the
	 * index of the item if it exists in the array. If the item does not exist
	 * in the array, it returns -1. Won't work with arrays of primitives.
	 * @author Erica Garand
	 * @param target - The item to find. Should be of the same type as the
	 * elements in the list.
	 * @param list - The array to search within. Should be of the same type
	 * as the target.*/
	public static int binarySearch (Comparable target, List<Comparable> list){
		int low = 0, high = list.size(), mid = 0;

		while (low <= high){
			mid = (low + high) / 2;
			if (list.get(mid).compareTo(target) == 0)
				return mid;
			else if (list.get(mid).compareTo(target) > 0)
				high = mid - 1;
			else
				low = mid + 1;
		}

		return -1;
	}

}
