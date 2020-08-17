package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BookTest {

    @Test
    void shouldUseEqualsBook() {
        Product first = new Book(10, "Унесенные ветром", 670, "Маргарет Митчелл");
        Product second = new Book(10, "Унесенные ветром", 670, "Маргарет Митчелл");

        assertEquals(first, second);
    }

}