package com.kodilla.patterns.builder.bigmac;

public enum Sauce {
    STANDARD("standard"),
    THOUSAND_ISLAND("thousand island"),
    BARBECUE("barbecue"),
    NO_SAUCE("no sauce");

    private String name;

    Sauce(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
