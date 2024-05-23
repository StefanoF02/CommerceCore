package com.commercecore.domain.entity;


public enum Category {
    MODE("MODE"),
    MOEBEL("MÖBEL"),
    TECHNIK("TECHNIK"),
    SPORT("SPORT"),
    SPIELZEUG("SPIELZEUG"),
    MULTIMEDIA("MULTIMEDIA");

    public final String category;

    private Category(String category){
        this.category = category;
    }

}
