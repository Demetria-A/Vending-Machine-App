package com.techelevator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTypeTest {


    @Test
    void getMessage() {
        assertEquals(
            "Crunch Crunch, Yum!",
            ProductType.CHIP.getMessage()
        );
        assertEquals(
            "Glug Glug, Yum!",
            ProductType.DRINK.getMessage()
        );
        assertEquals(
            "Munch Munch, Yum!",
            ProductType.CANDY.getMessage()
        );
        assertEquals(
            "Chew Chew, Yum!",
            ProductType.GUM.getMessage()
        );
    }

    @Test
    void getName() {
        assertEquals(
            "Chip",
            ProductType.CHIP.getName()
        );
        assertEquals(
            "Drink",
            ProductType.DRINK.getName()
        );
        assertEquals(
            "Candy",
            ProductType.CANDY.getName()
        );
        assertEquals(
            "Gum",
            ProductType.GUM.getName()
        );
    }
}