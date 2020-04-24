package com.galaxy.entity;

import java.io.Serializable;

/**
 * 部门表(Dept)实体类
 *
 * @author ThrStones
 * @since 2020-04-20 16:46:28
 */
public class Dept extends Base implements Serializable {
    private static final long serialVersionUID = 502547787621435411L;
    /**
    * 部门编号
    */
    private String departNo;
    /**
    * 部门名称
    */
    private String name;
    /**
    * 部门描述
    */
    private String description;


    public String getDepartNo() {
        return departNo;
    }

    public void setDepartNo(String departNo) {
        this.departNo = departNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Dept{" +
                ", departNo='" + departNo + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}