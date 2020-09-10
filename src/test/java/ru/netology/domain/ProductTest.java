package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    @Test
    void shouldCheckIfTheProductMatchesTheSearchByName() {
        Product first = new Product(15,"Унесенные ветром",760);

        boolean actual = first.matches("Унесенные ветром");

        assertTrue(actual);
    }

    @Test
    void shouldCheckSearchForProductIfThereIsAMistakeInName() {
        Product first = new Product(10, "Унесенные ветром", 670);

        boolean actual = first.matches("Унисенные ветром");

        assertFalse(actual);
    }

}