package com.example.android.selfmessages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {
    private String sender, message, message_date;

    public Message(String sender, String message)
    {
        this.sender = sender;
        this.message = message;
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        this.message_date = dateFormat.format(date);
    }

    public String getSender()
    {
        return sender;
    }

    public String getMessage()
    {
        return message;
    }

    public String getMessage_date()
    {
        return message_date;
    }
}
