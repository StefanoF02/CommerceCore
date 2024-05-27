package com.commercecore.domain.entity;

public enum Currency {
    EURO("EUR"),
    USDOLLAR("USD"),
    AUSDOLLAR("AUD"),
    CANDOLLAR("CAD"),
    YEN("YEN"),
    POUND("GBP"),
    FRANKEN("CHF");

    public final String currency;

    private Currency(String currency){ this.currency = currency;};

}
