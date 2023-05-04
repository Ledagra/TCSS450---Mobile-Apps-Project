package edu.uw.tcss450.lab3_authentication.ui.friends;

import java.io.Serializable;

public class Friend implements Serializable {
    private final String mName;   // name of the friend
    private final String mEmail;  // email of the friend

    public Friend(String name, String email) {
        this.mName = name;
        this.mEmail = email;
    }

    public String getName() {
        return mName;
    }

    public String getEmail() {
        return mEmail;
    }
}
