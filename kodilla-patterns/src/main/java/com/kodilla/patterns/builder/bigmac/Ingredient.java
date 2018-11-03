package com.kodilla.patterns.builder.bigmac;

public enum Ingredient {
    SALAD("salad"),
    ONION("onion"),
    BACON("bacon"),
    CUCUMBER("cucumber"),
    CHILLI_PEPPERS("chilli peppers"),
    MUSHROOMS("mushrooms"),
    SHRIMPS("shrimps"),
    CHEESE("cheese");

    private String name;

    Ingredient(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
