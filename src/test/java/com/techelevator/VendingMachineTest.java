package com.techelevator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineTest {

    VendingMachine unit = new VendingMachine();



    @Test
    void getBalance() {
        assertEquals(0, unit.getBalance());
    }

    @Test
    void testAddMoney() {
        assertEquals(10.0, unit.addMoney(10.0));
    }

    }