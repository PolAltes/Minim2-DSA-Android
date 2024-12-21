package com.example.proyectodsa_android.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Message {

    @SerializedName("messageID")
    @Expose
    private String messageID;

    @SerializedName("info")
    @Expose
    private String info;

    public Message(){}

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString(){
        return ("Message{ "+"messageID:"+messageID+'\''+",Information:"+info+"}");
    }
}
