package com.datechnologies.androidtest;

public class MessageModel{

    public String user;
    public String message;
    public int messageType;

    public MessageModel(String user, String message, int messageType){
        this.user = user;
        this.message = message;
        this.messageType = messageType;
    }
}