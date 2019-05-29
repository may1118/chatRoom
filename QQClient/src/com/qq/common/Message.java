package com.qq.client.common;

import java.io.Serializable;

public class Message implements Serializable {
    private String messType;
    private String sender;
    private String getter;
    private String content;
    private String sendTime;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getGetter() {
        return getter;
    }

    public void setGetter(String getter) {
        this.getter = getter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getMessType() {
        return messType;
    }

    public void setMessType(String messType) {
        this.messType = messType;
    }
}
