package musicinventorysystem;

/**
 *
 * @author Matt Gulbronson
 */
class User implements Comparable {

    String uName, pWord, fName, lName;
    boolean admin, signedOut;

    User(boolean admin) {
        this.admin = admin;
        this.signedOut = false;
    }

    @Override
    public int compareTo(Object o) {
        return lName.compareTo(o.toString());
    }
}
