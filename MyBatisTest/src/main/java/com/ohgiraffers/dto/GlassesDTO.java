package com.ohgiraffers.dto;

import java.io.Serializable;

public class GlassesDTO implements Serializable {

    private int glassesCode;
    private String glassesName;
    private int glassesPrice;
    private int categoryCode;

    public GlassesDTO() {
    }

    public GlassesDTO(int glassesCode, String glassesName, int glassesPrice, int categoryCode) {
        this.glassesCode = glassesCode;
        this.glassesName = glassesName;
        this.glassesPrice = glassesPrice;
        this.categoryCode = categoryCode;
    }

    public int getGlassesCode() {
        return glassesCode;
    }

    public void setGlassesCode(int glassesCode) {
        this.glassesCode = glassesCode;
    }

    public String getGlassesName() {
        return glassesName;
    }

    public void setGlassesName(String glassesName) {
        this.glassesName = glassesName;
    }

    public int getGlassesPrice() {
        return glassesPrice;
    }

    public void setGlassesPrice(int glassesPrice) {
        this.glassesPrice = glassesPrice;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    @Override
    public String toString() {
        return "GlassesDTO{" +
                "상품 코드=" + glassesCode +
                ", 상품명 ='" + glassesName + '\'' +
                ", 상품 가격=" + glassesPrice +
                ", 카테고리 코드=" + categoryCode +
                '}';
    }
}
