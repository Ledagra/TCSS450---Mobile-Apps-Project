package edu.uw.tcss450.lab3_authentication.ui.friends;

import java.util.ArrayList;

public class Constants {
    // ArrayList and return the ArrayList
    public static ArrayList<Friend> getFriendData()
    {
        // create an ArrayList of type Friend class
        ArrayList<Friend> FriendList
                = new ArrayList<Friend>();
        Friend emp1 = new Friend("Chinmaya Mohapatra",
                "chinmaya@gmail.com");
        FriendList.add(emp1);
        Friend emp2
                = new Friend("Ram prakash", "ramp@gmail.com");
        FriendList.add(emp2);
        Friend emp3 = new Friend("OMM Meheta",
                "mehetaom@gmail.com");
        FriendList.add(emp3);
        Friend emp4 = new Friend("Hari Mohapatra",
                "harim@gmail.com");
        FriendList.add(emp4);
        Friend emp5 = new Friend(
                "Abhisek Mishra", "mishraabhi@gmail.com");
        FriendList.add(emp5);
        Friend emp6 = new Friend("Sindhu Malhotra",
                "sindhu@gmail.com");
        FriendList.add(emp6);
        Friend emp7 = new Friend("Anil sidhu",
                "sidhuanil@gmail.com");
        FriendList.add(emp7);
        Friend emp8 = new Friend("Sachin sinha",
                "sinhas@gmail.com");
        FriendList.add(emp8);
        Friend emp9 = new Friend("Amit sahoo",
                "sahooamit@gmail.com");
        FriendList.add(emp9);
        Friend emp10 = new Friend("Raj kumar",
                "kumarraj@gmail.com");
        FriendList.add(emp10);

        return FriendList;
    }
}
