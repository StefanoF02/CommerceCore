package com.commercecore.productService.entity.enums;


public enum Category {
    FASHION("FASHION"),
    FURNITURE("FURNITURE"),
    TECH("TECHNOLOGY"),
    SPORT("SPORT"),
    TOYS("TOYS"),
    MULTIMEDIA("MULTIMEDIA");

    public final String category;

    private Category(String category){
        this.category = category;
    }

}
