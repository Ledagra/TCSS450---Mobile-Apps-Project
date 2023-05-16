package edu.uw.tcss450.group8project.ui.messages;

import java.io.Serializable;

public class Message implements Serializable {

    private final String name;
    private final String recentText;
    private final String divider;

    Message(String name, String recentText, String divider){
        this.name = name;
        this.recentText = recentText;
        this.divider = divider;
    }

    public String getName() {
        return name;
    }

    public String getRecentText() {
        return recentText;
    }

    public String getDivider() {
        return divider;
    }
}
