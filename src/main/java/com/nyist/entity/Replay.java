package com.nyist.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by lvbowen on 2017/4/3.
 */
@Entity
public class Replay {
    @Id
    @GeneratedValue
    private Integer replayId;


    private Integer userId;
    private Integer fatherId;
    private String userName;
    private String date;
    private String content;

    public Replay() {
    }
    public Integer getFatherId() {
        return fatherId;
    }

    public void setFatherId(Integer fatherId) {
        this.fatherId = fatherId;
    }
    public Integer getReplayId() {
        return replayId;
    }

    public void setReplayId(Integer replayId) {
        this.replayId = replayId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
