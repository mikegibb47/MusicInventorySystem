package musicinventorysystem;

import gui.RegisterFrame;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/* TABLE OF CONTENTS (Use ctrl+f to navigate, case sensitive)
 * 
 * 1- VARIABLES
 * 2- CONSTRUCTORS
 * 3- GETTER METHODS
 * 4- SETTER METHODS
 * 5- OTHER METHODS
 */

/**A class that holds the inventory data in memory and manipulates it as needed.
 * WARNING: DO NOT USE THE BLANK CONSTRUCTOR. IT IS FOR TESTING PURPOSES ONLY.
 * @author Erica Garand*/
public class InventorySystem {

    ///////////////////////
    ////// VARIABLES //////
    ///////////////////////
    /**
     * A number that points to the spot in the user list that contains the
     * information of the currently logged in user.
     */
    private int currentUser;

    /**
     * A list that holds the information of all registered users in memory.
     */
    private List<Account> users;

	
	//////////////////////////
	////// CONSTRUCTORS //////
	//////////////////////////
	
        /**Creates an inventory system. WARNING: USING THIS CONSTRUCTOR MAKES
         * THE OBJECT CONTAIN INACCURATE DUMMY DATA. THIS CONSTRUCTOR IS FOR
         * TESTING PURPOSES ONLY.
         * @author Erica Garand
         * @deprecated use the other constructor instead.  
         */
        @Deprecated
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
		
		instruments = bubbleSort((List)instruments);
		users = bubbleSort((List)users);
                
                for (int i = 0; i < users.size();i++)
                    System.out.println(users.get(i));

	}
        
        /**Creates an inventory system.
         @author Erica Garand
         @param users - the list of users that this inventory system will keep track of.
         * Should contain at least one admin.
         @param instruments - the list of instruments that this inventory system will
         * keep track of.*/
        public InventorySystem(List<Account> users, List<Instrument> instruments){
            this.users = new ArrayList<Account>();
            this.users.addAll(users);
            this.instruments = new ArrayList<Instrument>();
            this.instruments.addAll(instruments);
            
            instruments = bubbleSort((List)instruments);
            users = bubbleSort((List)users);
        }
	
	
	////////////////////////////
	////// GETTER METHODS //////
	////////////////////////////
	
	/**Used to retrieve a list of all the instruments a specific student has used in the past.
	 * @author Erica Garand
         @param u - The account to find the signout history of.*/
	public List<Instrument> getStudentSignoutHistory(Account u){
            ArrayList<Instrument> stuff = new ArrayList<Instrument>();
            for (int i = 0; i < instruments.size(); i++){
                if (instruments.get(i).getCurrentUser().equals(u.getUsername()))
                    stuff.add(instruments.get(i));
            }
            return stuff;
	}

        users.add(new Account("Bilbo", "Baggins", "ahobbit", "arkenstone", false, false));
        users.add(new Account("Corrin", "of Nohr", "yatomaster", "anankos", false, false));
        users.add(new Account("John", "Doe", "mysteryman", "whoami", false, true));
        users.add(new Account("TheMighty", "AdminGuy", "rulerofall", "sauron", true, false));

	/**Used to retrieve a list of all the users currently used.
	 * @author Erica Garand*/
	public Account getLoggedInUser(){
		if( currentUser >= 0 && currentUser < users.size() )
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
		users.add(u);
	}

	/**Allows an admin profile to manually remove a user from the user file, if necessary.
	 * @author Erica Garand
         * @param u - The account to remove permanently from memory*/
	public void removeUser(Account u){
		if( currentUser >= 0 && currentUser < users.size() && users.get(currentUser).isAdmin() == true ){
			int index = binarySearch(u, (List)users);
                        if (index >= 0 && index != currentUser)
                            users.remove(index);
		}
	}
        
        
        
        /**Allows an admin profile to add or remove admin privileges to any account except for itself.
         @author Erica Garand
         @param u - The account to change the admin status of.
         @param a - the status to change the account's status to. True if they should be an admin,
         * false if they should not be an admin.*/
        public void changeAdminStatus(Account u, boolean a){
            if ( currentUser >= 0 && currentUser < users.size() && users.get(currentUser).isAdmin() == true ){
                int index = binarySearch(u, (List)users);
                if (index >= 0 && index != currentUser)
                    users.get(index).setAdminStatus(a);
            }
        }

	/**Allows an admin profile to manually add an instrument to the file.
	 * @author Erica Garand
         @param a - The instrument to add to the list. Should be newly created, as key components of Insrument
         * objects are unchangeable once they're created.*/
	public void addInstrument(Instrument a){
		if( currentUser >= 0 && currentUser < users.size() && users.get(currentUser).isAdmin() == true ){
			instruments.add(a);
		}
	}

	/**Allows an admin profile to manually remove an Instrument from the file.
	 * @author Erica Garand
         @param barcode - the id number or barcode of the instrument to be removed from memory.*/
	public void removeInstrument(String barcode){
		if( currentUser >= 0 && currentUser < users.size() && users.get(currentUser).isAdmin() == true ){
			Instrument temp = new Instrument("", barcode, false, "", "");
                        int index = binarySearch(temp, (List)instruments);
                        if (index >= 0 && instruments.get(index).isAvailable() == true)
                            instruments.remove(index);
		}
	}

	/**Allows an admin profile to indicate whether or not an instrument is out for service.
	 * @author Erica Garand
         @param barcode - the id number or barcode of the instrument to be marked as out for service.*/
	public void serviceAnInstrument(String barcode){
		if( currentUser >= 0 && currentUser < users.size() && users.get(currentUser).isAdmin() == true ){
			Instrument temp = new Instrument("", barcode, false, "", "");
                        int index = binarySearch(temp, (List)instruments);
                        if (index >= 0 && instruments.get(index).isAvailable() == true)
                            instruments.get(index).service();
		}
	}

	/**Allows any profile to sign out an instrument.
	 * @author Erica Garand
         @param barcode - the id number or barcode of the instrument to be signed out.*/
	public void signOutInstrument(String barcode){
		if( currentUser >= 0 && currentUser < users.size() ){
			Instrument temp = new Instrument("", barcode, false, "", "");
                        int index = binarySearch(temp, (List)instruments);
                        if (index >= 0 && instruments.get(index).isAvailable() == true)
                            instruments.get(index).signOut(users.get(currentUser).getUsername());
		}
	}

	/**Allows any profile to sign back in an instrument.
	 * @author Erica Garand
         @param barcode - the id number or barcode of the instrument to be signed back in*/
	public void signInInstrument(String barcode){
		if( currentUser >= 0 && currentUser < users.size() ){
			Instrument temp = new Instrument("", barcode, false, "", "");
                        int index = binarySearch(temp, (List)instruments);
                        if (index >= 0 && instruments.get(index).isAvailable() == false)
                            instruments.get(index).signIn();
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

    /**
     * Allows an admin profile to manually remove a user from the user file, if
     * necessary.
     *
     * @author Erica Garand
     */
    public void removeUser(Account u) {
        if (currentUser >= 0 && currentUser < users.size() && users.get(currentUser).isAdmin() == true) {
            int index = binarySearch(u, (List) users);
            if (index >= 0 && index != currentUser) {
                users.remove(index);
            }
        }
    }

	/**
	 * Sorts an unsorted array of objects which implement the comparable
	 * interface using the bubble-sort algorithm
	 *
	 * @param unsorted - the array of comparable objects to be sorted
	 * @author Matthew Gulbronson
	 */
	public static List<Comparable> bubbleSort(List<Comparable> unsorted) {
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
	 * in the array, it returns -1.</br>
         * You MUST cast the parameter being passed to this method as a (List).
	 * @author Erica Garand
	 * @param target - The item to find. Should be of the same type as the
	 * elements in the list.
	 * @param list - The array to search within. Should be of the same type
	 * as the target. NOTE: You must cast this parameter as a (List) for it
         * to work!*/
	public static int binarySearch (Comparable target, List<Comparable> list){
		int low = 0, high = list.size(), mid = 0;

    /**
     * Allows an admin profile to manually remove an Instrument from the file.
     *
     * @author Erica Garand
     */
    public void removeInstrument(String barcode) {
        if (currentUser >= 0 && currentUser < users.size() && users.get(currentUser).isAdmin() == true) {
            Instrument temp = new Instrument("", barcode, false, "", "");
            int index = binarySearch(temp, (List) instruments);
            if (index >= 0 && instruments.get(index).isAvailable() == true) {
                instruments.remove(index);
            }
        }
    }

    /**
     * Allows an admin profile to indicate whether or not an instrument is out
     * for service.
     *
     * @author Erica Garand
     */
    public void serviceAnInstrument(String barcode) {
        if (currentUser >= 0 && currentUser < users.size() && users.get(currentUser).isAdmin() == true) {
            Instrument temp = new Instrument("", barcode, false, "", "");
            int index = binarySearch(temp, (List) instruments);
            if (index >= 0 && instruments.get(index).isAvailable() == true) {
                instruments.get(index).service();
            }
        }
    }

    /**
     * Allows any profile to sign out an instrument.
     *
     * @author Erica Garand
     */
    public void signOutInstrument(String barcode) {
        if (currentUser >= 0 && currentUser < users.size()) {
            Instrument temp = new Instrument("", barcode, false, "", "");
            int index = binarySearch(temp, (List) instruments);
            if (index >= 0 && instruments.get(index).isAvailable() == true) {
                instruments.get(index).signOut(users.get(currentUser).getUsername());
            }
        }
    }

    /**
     * Allows any profile to sign back in an instrument.
     *
     * @author Erica Garand
     */
    public void signInInstrument(String barcode) {
        if (currentUser >= 0 && currentUser < users.size()) {
            Instrument temp = new Instrument("", barcode, false, "", "");
            int index = binarySearch(temp, (List) instruments);
            if (index >= 0 && instruments.get(index).isAvailable() == false) {
                instruments.get(index).signIn();
            }
        }
    }

    /**
     * Used to log in a user to the program.
     *
     * @author Erica Garand
     * @param user - The username of the user trying to log in.
     * @param pass - The password of the user trying to log in.
     */
    public void logIn(String user, String pass) {
        Account temp = new Account("", "", user, pass, false, false);

        //search through all the accounts
        int index = binarySearch(temp, (List) users);

        //if a matching account it found, set currentUser to point to that account
        if (index >= 0) {
            currentUser = index;
        } //if no matching account was found, throw an exception
        else {
            System.out.println("Put exception throwing stuff here");
        }
    }

    /**
     * Used to log out the user currently using the program.
     *
     * @author Erica Garand
     */
    public void logOut() {
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
    public static List<Comparable> bubbleSort(List<Comparable> unsorted) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < unsorted.size() - 1; i++) {
                if (unsorted.get(i).compareTo(unsorted.get(i + 1)) > 0) {
                    Collections.swap(unsorted, i, i + 1);
                    swapped = true;
                }
            }
        } while (swapped);

        return unsorted;
    }

    /**
     * Does a binary search for an item in an array of items, then returns the
     * index of the item if it exists in the array. If the item does not exist
     * in the array, it returns -1.</br>
     * You MUST cast the parameter being passed to this method as a (List).
     *
     * @author Erica Garand
     * @param target - The item to find. Should be of the same type as the
     * elements in the list.
     * @param list - The array to search within. Should be of the same type as
     * the target.
     */
    public static int binarySearch(Comparable target, List<Comparable> list) {
        int low = 0, high = list.size(), mid = 0;

        while (low <= high) {
            mid = (low + high) / 2;
            if (list.get(mid).compareTo(target) == 0) {
                return mid;
            } else if (list.get(mid).compareTo(target) > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public String encrypt(String string) {
        try {
            //declare the encrypting method
            MessageDigest mesd = MessageDigest.getInstance("SHA-256");
            //encrypt the string
            mesd.update(string.getBytes());
            byte byteData[] = mesd.digest();
            String encrypted = "";
            for (int i = 0; i < byteData.length; ++i) {
                encrypted += (Integer.toHexString((byteData[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return encrypted;
        } catch (NoSuchAlgorithmException ex) {
            //if the encrypting algorithm can't be found return an error saying so
            Logger.getLogger(RegisterFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
