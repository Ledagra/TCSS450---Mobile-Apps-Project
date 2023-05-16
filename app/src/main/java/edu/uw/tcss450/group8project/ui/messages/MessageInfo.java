package edu.uw.tcss450.group8project.ui.messages;

import java.util.ArrayList;

public class MessageInfo {



    private MessageInfo(){
        /* Empty private Constructor */
    }

    public static ArrayList<Message> getMessageData(){
        //Create some examples for the message list

        ArrayList<Message> messageList = new ArrayList<>();

        Message exp1 = new Message("Adam", "How are you?", "_________________________________________________");
        Message exp2 = new Message("Bob", "How are you?", "_________________________________________________");
        Message exp3 = new Message("Carl", "How are you?", "_________________________________________________");
        Message exp4 = new Message("David", "How are you?", "_________________________________________________");
        Message exp5 = new Message("Fred", "How are you?", "_________________________________________________");
        Message exp6 = new Message("George", "How are you?", "_________________________________________________");
        Message exp7 = new Message("Harry", "How are you?", "_________________________________________________");
        Message exp8 = new Message("Ian", "How are you?", "_________________________________________________");
        Message exp9 = new Message("Jake", "How are you?", "_________________________________________________");
        Message exp10 = new Message("Kyle", "How are you?", "_________________________________________________");

        messageList.add(exp1);
        messageList.add(exp2);
        messageList.add(exp3);
        messageList.add(exp4);
        messageList.add(exp5);
        messageList.add(exp6);
        messageList.add(exp7);
        messageList.add(exp8);
        messageList.add(exp9);
        messageList.add(exp10);

        return messageList;

    }
}
