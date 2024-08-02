package com.example.vtf.Engine;


public class Message {
    String message;
    public enum Status{
        SUCCESS,
        FAIL,
        INFO
    }
    Status stt;

    public Message(){

    }

    public Message(String message, Status status){
        this.message = message;
        this.stt = status;
    }

    public String getMessage(){
        return this.message;
    }
    public void setMessage(String msg){
        this.message = msg;
    }
    public void setStatus(Status stt){
        this.stt = stt;
    }
    public Status getStatus(){
        return this.stt;
    }
    
    
}
