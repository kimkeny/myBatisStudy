package com.ohgiraffers.dto;

import java.io.Serializable;

public class LensDTO implements Serializable {

    private int lensCode;
    private String lensName;
    private int lensPrice;
    private int categoryCode;

    public LensDTO() {
    }

    public LensDTO(int lensCode, String lensName, int lensPrice, int categoryCode) {
        this.lensCode = lensCode;
        this.lensName = lensName;
        this.lensPrice = lensPrice;
        this.categoryCode = categoryCode;
    }

    public int getLensCode() {
        return lensCode;
    }

    public void setLensCode(int lensCode) {
        this.lensCode = lensCode;
    }

    public String getLensName() {
        return lensName;
    }

    public void setLensName(String lensName) {
        this.lensName = lensName;
    }

    public int getLensPrice() {
        return lensPrice;
    }

    public void setLensPrice(int lensPrice) {
        this.lensPrice = lensPrice;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    @Override
    public String toString() {
        return "lensDTO{" +
                "lensCode=" + lensCode +
                ", lensName='" + lensName + '\'' +
                ", lensPrice=" + lensPrice +
                ", categoryCode=" + categoryCode +
                '}';
    }
}
