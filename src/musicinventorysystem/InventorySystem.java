package musicinventorysystem;

import java.util.LinkedList;
import java.lang.reflect.Array;

/**
 *
 * @author Matt Gulbronson
 */
public class InventorySystem {

    static Account testUser;
    static LinkedList<User> users = new LinkedList();
    static LinkedList<Instruments> instruments = new LinkedList();
    static LinkedList<Instruments> instrumentsOut = new LinkedList();
    static LinkedList<Instruments> instrumentsIn = new LinkedList();
    
    public static void main(String[] args) {
	testUser = new Account("TheMighty", "Admin", true, false);
	
	instruments = new LinkedList<Instrument>();
	instruments.add(new Instrument("Clarinet", 1, true, "", "Bilbo Baggins,Corrin of Nohr"));
	instruments.add(new Instrument("Trumpet", 2, true, "", ""));
	instruments.add(new Instrument("Trombone", 3, false, "John Doe", "Bilbo Baggins,John Doe"));
	instruments.add(new Instrument("Cow Bell", 4, false, "Out For Service", ""));
	
	//Test your methods below...
		
	}

    void addUser(User u) {
        users.add(u);
    }

    void removeUser(User u) {
        users.remove(u);
    }

    void addInstrument(Intrument i) {
        instruments.add(i);
    }
    
    void removeInstrument(Instrument i){
        instruments.remove(i)
    }
    
    

    /**
     * Sorts an unsorted array of objects which implement the comparable
     * interface using the bubble-sort algorithm
     *
     * @param unsorted the array of comparable objects to be sorted
     */
    public void bubbleSort(Comparable[]<User> unsorted) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < unsorted.length - 1; i++) {
                if (unsorted[i].compareTo(unsorted[i + 1].lName) > 0) {
                    unsorted = (Comparable[]) swap(i, i + 1, unsorted);
                    swapped = true;
                }
            }
        } while (swapped);
    }

    /**
     * Swaps two objects in an array
     *
     * @param m
     * @param n
     * @param array the array of object
     * @return the array with the objects at indices m & n switched
     */
    public Object[] swap(int m, int n, Object[] array) {
        Object temp = array[m];
        Array.set(array, m, array[n]);
        Array.set(array, n, temp);
        return array;
    }
    
    
    ///////////////////////////////////////////////////////
    //// THIS IS A SHITTON OF METHODS WE NEED TO WRITE ////
    ///////////////////////////////////////////////////////
    /*/
    // Pick your methods! Write yourself down as the author in the javadoc above each
    // method you want, and then start coding. The only things you should be using to
    // create these methods are the static variables above; the instrument list and the
    // user object.
    // 
    // These methods will be used by various actionlisteners in the GUI stuff, and
    // have access to the files/wherever we're storing stuff, and that's what will make
    // the program work. Don't worry about where we're getting the data or the GUI yet
    // though, just use the dummy data I've put in the main method and the console to
    // test if your code works.
    //
    // Please note that the methods don't have their parameters or returns set properly.
    // Be sure to modify them so they take in whatever variables you need them to. And
    // javadoc them properly!!
    /*/
    
    
    /**Allows an admin profile to manually add a user to the file.
	 * @author ??*/
	public static void addUser(){
		if (testUser != null && testUser.isAdmin() == true){
			
		}
	}
	
	/**Allows an admin profile to manually remove a user from the file.
	 * @author ??*/
	public static void removeUser(){
		if (testUser != null && testUser.isAdmin() == true){
			
		}
	}
	
	/**Allows an admin profile to manually add an instrument to the file.
	 * @author ??*/
	public static void addInstrumentToFile(){
		if (testUser != null && testUser.isAdmin() == true){
			
		}
	}
	
	/**Allows an admin profile to manually remove an Instrument from the file.
	 * @author ??*/
	public static void removeInstrumentFromFile(){
		if (testUser != null && testUser.isAdmin() == true){
			
		}
	}
	
	/**Allows an admin profile to indicate whether or not an instrument is out for service.
	 * @author ??*/
	public static void serviceAnInstrument(){
		if (testUser != null && testUser.isAdmin() == true){
			
		}
	}

	/**Allows any profile to sign out an instrument.
	 * @author ??*/
	public static void signOutInstrument(){
		if (testUser != null){
			
		}
	}
	
	/**Allows any profile to sign back in an instrument.
	 * @author ??*/
	public static void signInInstrument(){
		if (testUser != null){
			
		}
	}
	
	/**Used to retrieve a list of all the instruments a specific student has used in the past.
	 * @author ??*/
	public static LinkedList<Instrument> getStudentSignoutHistory(){
		return null;
	}

}
