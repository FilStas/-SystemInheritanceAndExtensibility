package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    @Test
    void shouldUseEqualsSmartphone() {
        Product first = new Smartphone(15, "iPhone XR", 45000, "Apple");
        Product second = new Smartphone(15, "iPhone XR", 45000, "Apple");

        assertEquals(first, second);
    }

    @Test
    void shouldCheckIfTheSmartphoneMatchesTheSearchByManufacturer() {
        Smartphone seventh = new Smartphone(16, "Huawei P30", 31000, "Huawei");

        boolean actual = seventh.matches("Huawei");

        assertTrue(actual);
    }

    @Test
    void shouldCheckIfTheSmartphoneMatchesTheSearchByName() {
        Smartphone seventh = new Smartphone(16, "Huawei P30", 31000, "Huawei");

        boolean actual = seventh.matches("Huawei P30");

        assertTrue(actual);
    }

    @Test
    void shouldChecksearchForSmartphoneIfThereIsAMistakeInName() {
        Smartphone seventh = new Smartphone(16, "Huawei P30", 31000, "Huawei");

        boolean actual = seventh.matches("Huawei P3");

        assertFalse(actual);
    }
}