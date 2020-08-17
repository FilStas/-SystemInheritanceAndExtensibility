package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmartphoneTest {

    @Test
    void shouldUseEqualsSmartphone() {
        Product first = new Smartphone(15, "iPhone XR", 45000, "Apple");
        Product second = new Smartphone(15, "iPhone XR", 45000, "Apple");

        assertEquals(first, second);
    }
}