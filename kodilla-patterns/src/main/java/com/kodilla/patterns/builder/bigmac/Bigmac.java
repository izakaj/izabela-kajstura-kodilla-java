package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class Bigmac {
    private final Bun bun;
    private final int burgers;
    private final Sauce sauce;
    private List<Ingredient> ingredients = new ArrayList<>();

    public static class BigmacBuilder {
        private Bun bun;
        private int burgers;
        private Sauce sauce;
        private List<Ingredient> ingredients = new ArrayList<>();

        public BigmacBuilder bun(Bun bun) {
            this.bun = bun;
            return this;
        }

        public BigmacBuilder burgers(int numberOfBurgers) {
            this.burgers = numberOfBurgers;
            return this;
        }

        public BigmacBuilder sauce(Sauce sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder ingredient(Ingredient ingredient) {
            this.ingredients.add(ingredient);
            return this;
        }

        public Bigmac build() {
            if(burgers < 0) {
                throw new IllegalStateException("Number cannot be less than 0");
            } else if(burgers > 4) {
                throw new IllegalStateException("You can't have more than 4 burgers.");
            }
            if(bun == null) {
                throw new IllegalStateException("You need to choose the type of bun");
            }
            if(sauce == null) {
                throw new IllegalStateException("You need to choose the sauce");
            }
            return new Bigmac(bun, burgers, sauce, ingredients);
        }
    }

    public Bigmac(Bun bun, int burgers, Sauce sauce, List<Ingredient> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = ingredients;
    }

    public Bun getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Your BigMac:\n" +
                "- bun: " + bun +
                "\n- number of burgers: " + burgers +
                "\n- sauce: " + sauce +
                "\n- ingredients: " + ingredients;
    }
}
