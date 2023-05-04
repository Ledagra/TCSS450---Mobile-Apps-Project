package edu.uw.tcss450.lab3_authentication.ui.friends;

import java.util.ArrayList;

/**
 * Class to create list of friends using mock data.
 * @author Stephen VanLuven
 */

public final class Constants {
    /**
     * Private constructor to prevent instantiation.
     */
    private Constants() {
        // Prevent instantiation
    }

    /**
     * Method to create list of friends using mock data.
     * @return ArrayList of friends
     */
    public static ArrayList<Friend> getFriendData() {
        // create an ArrayList of type Friend class
        ArrayList<Friend> friendList
                = new ArrayList<Friend>();
        Friend emp1 = new Friend("Adam",
                "adam@gmail.com");
        friendList.add(emp1);
        Friend emp2
                = new Friend("Bob", "bob@gmail.com");
        friendList.add(emp2);
        Friend emp3 = new Friend("Carl",
                "carl@gmail.com");
        friendList.add(emp3);
        Friend emp4 = new Friend("David",
                "david@gmail.com");
        friendList.add(emp4);
        Friend emp5 = new Friend(
                "Fred", "fred@gmail.com");
        friendList.add(emp5);
        Friend emp6 = new Friend("George",
                "george@gmail.com");
        friendList.add(emp6);
        Friend emp7 = new Friend("Harry",
                "harry@gmail.com");
        friendList.add(emp7);
        Friend emp8 = new Friend("Ian",
                "Ian@gmail.com");
        friendList.add(emp8);
        Friend emp9 = new Friend("Jake",
                "jake@gmail.com");
        friendList.add(emp9);
        Friend emp10 = new Friend("Kyle",
                "kyle@gmail.com");
        friendList.add(emp10);

        return friendList;
    }
}
