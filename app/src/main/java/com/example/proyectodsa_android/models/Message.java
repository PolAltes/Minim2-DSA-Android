package com.example.proyectodsa_android.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Message {

    @SerializedName("messageID")
    @Expose
    private String messageID;

    @SerializedName("idOrigin")
    @Expose
    private String idOrigin;

    @SerializedName("idTarget")
    @Expose
    private String idTarget;

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

    public String getIdOrigin() {
        return idOrigin;
    }

    public void setIdOrigin(String idOrigin) {
        this.idOrigin = idOrigin;
    }

    public String getIdTarget() {
        return idTarget;
    }

    public void setIdTarget(String idTarget) {
        this.idTarget = idTarget;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString(){
        return ("Message{ "+"messageID:"+messageID+'\''+",Origin:"+idOrigin+'\''+",Target:"+idTarget+'\''+",Information:"+info+"}");
    }
}
