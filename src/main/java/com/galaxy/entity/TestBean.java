package com.galaxy.entity;

import java.io.Serializable;

/**
 * (Testbean)实体类
 *
 * @author ThrStones
 * @since 2020-04-16 08:51:53
 */
public class TestBean implements Serializable {
    private static final long serialVersionUID = -60504860003088241L;
    
    private Integer id;
    
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}