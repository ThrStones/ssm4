package com.galaxy.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Meeting)实体类
 *
 * @author ThrStones
 * @since 2020-04-24 08:44:20
 */
public class Meeting extends Base implements Serializable {
    private static final long serialVersionUID = -50975837883029092L;

    private Account account;

    private Date startTime;

    private Date endTime;

    private String title;

    private String content;

    private String address;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}