package edu.uw.tcss450.group8project.ui.friends;

import java.io.Serializable;

/**
 * Class to encapsulate a Friend object.
 */
public class Friend implements Serializable {
    /** The friend's name. */
    private final String mName;   // name of the friend
    /** The friend's email. */
    private final String mEmail;  // email of the friend

    public static class Builder {
        private final String mName;
        private final String mEmail;
        public Builder(String name, String email) {
            this.mName = name;
            this.mEmail = email;
        }
        public Friend build() { return new Friend(this); }
    }

    public Friend(final Builder builder) {
        this.mName = builder.mName;
        this.mEmail = builder.mEmail;
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
    @Override
    public boolean equals(Object obj) {
        boolean result = false;

        if (obj instanceof Friend) {
            Friend ptr = (Friend) obj;
            result = (ptr.getName()).equals(this.getName())
                    && (ptr.getEmail()).equals(this.getEmail());
        }
        return result;
    }
}
