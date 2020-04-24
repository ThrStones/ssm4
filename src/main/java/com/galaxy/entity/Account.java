package com.galaxy.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Account)实体类
 *
 * @author ThrStones
 * @since 2020-04-20 10:37:09
 */
public class Account extends Base implements Serializable {
    private static final long serialVersionUID = -54620413683763279L;

    private String name;
    private String password;

    private Date createTime;
    private Date updateTime;
    private Date accessTime;
    private boolean deleteFlag;
    private String remark;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}