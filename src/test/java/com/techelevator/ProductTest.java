package com.techelevator;

import org.junit.jupiter.api.Test;
import org.junit.platform.engine.TestExecutionResult;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
Product unit = new Product("foo", 2.25, ProductType.fromName("Chip") );
Product unit2 = new Product("Tester", 4.65, ProductType.fromName("Drink"));
Product unit3 = new Product("kung", 3.35, ProductType.fromName("Candy"));
Product unit4 = new Product("Tastier", 5.75, ProductType.fromName("Gum"));

    @Test
    void getName() {
        assertEquals("foo", unit.getName());
        assertEquals("Tester", unit2.getName());
        assertEquals("kung", unit3.getName());
        assertEquals("Tastier", unit4.getName());
    }



    @Test
    void getPrice() {
        assertEquals(2.25, unit.getPrice());
        assertEquals(4.65, unit2.getPrice());
        assertEquals(3.35, unit3.getPrice());
        assertEquals(5.75, unit4.getPrice());
    }

    @Test
    void getType() {
        assertEquals(ProductType.CHIP, unit.getType());
        assertEquals(ProductType.DRINK, unit2.getType());
        assertEquals(ProductType.CANDY, unit3.getType());
        assertEquals(ProductType.GUM, unit4.getType());
    }

    @Test
    void getQuantity() {
        assertEquals( 5, unit.getQuantity());
    }

    @Test
    void purchase() {
        assertEquals( 4, unit.purchase());
    }

    @Test
    void ToString() {
        assertEquals("foo $2.25 (5)", unit.toString());
    }

    @Test
    void isOutOfStock() {
        assertFalse(unit.isOutOfStock());
    }
}