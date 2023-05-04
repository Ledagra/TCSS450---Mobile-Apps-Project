package edu.uw.tcss450.lab3_authentication.ui.friends;

import java.io.Serializable;

/**
 * Class to encapsulate a Friend object.
 */
public class Friend implements Serializable {
    /** The friend's name. */
    private final String mName;   // name of the friend
    /** The friend's email. */
    private final String mEmail;  // email of the friend

    /**
     * Constructor for a Friend object.
     * @param name name of friend
     * @param email email of friend
     */
    public Friend(final String name, final String email) {
        this.mName = name;
        this.mEmail = email;
    }

    /**
     * Getter for the friend's name.
     * @return String name
     */
    public String getName() {
        return mName;
    }

    /**
     * Getter for the friend's email.
     * @return String email
     */
    public String getEmail() {
        return mEmail;
    }
}
