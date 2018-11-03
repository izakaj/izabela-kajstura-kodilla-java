package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {
    @Test
    public void testBigmacNew() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun(Bun.WITHOUT_SESAME)
                .burgers(1)
                .sauce(Sauce.THOUSAND_ISLAND)
                .ingredient(Ingredient.SALAD)
                .ingredient(Ingredient.CHEESE)
                .ingredient(Ingredient.MUSHROOMS)
                .ingredient(Ingredient.ONION)
                .build();
        System.out.println(bigmac);
        //When
        int howManyIngredients = bigmac.getIngredients().size();
        int howManyBurgers = bigmac.getBurgers();
        Bun whichBun = bigmac.getBun();
        Sauce whichSauce = bigmac.getSauce();
        //Then
        Assert.assertEquals(4, howManyIngredients);
        Assert.assertEquals(1, howManyBurgers);
        Assert.assertEquals(Bun.WITHOUT_SESAME, whichBun);
        Assert.assertEquals(Sauce.THOUSAND_ISLAND, whichSauce);
    }

    @Test
    public void testBigmacNewNoBun() {
        //Given
        String s = "";
        //When
        try {
            Bigmac bigmac = new Bigmac.BigmacBuilder()
                    .burgers(1)
                    .sauce(Sauce.THOUSAND_ISLAND)
                    .ingredient(Ingredient.SALAD)
                    .ingredient(Ingredient.CHEESE)
                    .ingredient(Ingredient.MUSHROOMS)
                    .ingredient(Ingredient.ONION)
                    .build();
        } catch (IllegalStateException e) {
            s = e.getMessage();
        }
        //Then
        Assert.assertEquals("You need to choose the type of bun", s);
    }

    @Test
    public void testBigmacTooManyBurgers() {
        //Given
        String s = "";
        //When
        try {
            Bigmac bigmac = new Bigmac.BigmacBuilder()
                    .bun(Bun.WITHOUT_SESAME)
                    .burgers(5)
                    .sauce(Sauce.THOUSAND_ISLAND)
                    .ingredient(Ingredient.SALAD)
                    .ingredient(Ingredient.CHEESE)
                    .ingredient(Ingredient.MUSHROOMS)
                    .ingredient(Ingredient.ONION)
                    .build();
        } catch (IllegalStateException e) {
            s = e.getMessage();
        }
        //Then
        Assert.assertEquals("You can't have more than 4 burgers.", s);
    }

    @Test
    public void testBigmacNewNoIngredients() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun(Bun.WITHOUT_SESAME)
                .burgers(1)
                .sauce(Sauce.THOUSAND_ISLAND)
                .build();
        System.out.println(bigmac);
        //When
        int howManyIngredients = bigmac.getIngredients().size();
        //Then
        Assert.assertEquals(0, howManyIngredients);
    }
}
