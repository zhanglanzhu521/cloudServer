package com.hellowood.dynamicdatasource.modal;

import java.io.Serializable;

/**
 * @Title :BEAN
 * @Description :BEAN
 * @Author : zhanglz
 * @Date : 2018/8/12
 */
public class Product implements Serializable {
    private static final long serialVersionUID = 1435515995276255188L;

    private long id;
    private String name;
    private long price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
