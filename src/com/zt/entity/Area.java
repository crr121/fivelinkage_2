package com.zt.entity;

import java.io.Serializable;

public class Area implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;
    private String name;
    private int layer;

    public Area(String code, String name, int layer) {
        super();
        this.code = code;
        this.name = name;
        this.layer = layer;
    }

    public Area() {
        super();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    @Override
    public String toString() {
        return "Area [code=" + code + ", layer=" + layer + ", name=" + name
                + "]";
    }

}