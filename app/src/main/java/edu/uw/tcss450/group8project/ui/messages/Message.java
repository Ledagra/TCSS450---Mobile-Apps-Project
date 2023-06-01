package edu.uw.tcss450.group8project.ui.messages;

import java.io.Serializable;

public class Message implements Serializable {

    private final String name;
    private final String recentText;

    private final String recentTime;


    Message(String name, String recentText, String recentTime){
        this.name = name;
        this.recentText = recentText;
        this.recentTime = recentTime;

    }

    public String getName() {
        return name;
    }

    public String getRecentText() {
        return recentText;
    }

    public String getTime() {return recentTime;}

}
