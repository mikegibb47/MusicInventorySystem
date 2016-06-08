package musicinventorysystem;

import java.util.LinkedList;

/**
 *
 * @author Matt Gulbronson
 */
public class InventorySystem {

    LinkedList<User> users = new LinkedList();
    LinkedList<Instruments> instruments = new LinkedList();

    void addUser(User u) {
        users.add(u);
    }

    void removeUser(User u) {
        
    }

}
