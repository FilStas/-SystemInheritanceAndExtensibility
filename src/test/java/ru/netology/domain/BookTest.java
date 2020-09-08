package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class BookTest {

    @Test
    void shouldUseEqualsBook() {
        Product first = new Book(10, "Унесенные ветром", 670, "Маргарет Митчелл");
        Product second = new Book(10, "Унесенные ветром", 670, "Маргарет Митчелл");

        assertEquals(first, second);
    }

    @Test
    void shouldCheckIfTheBookMatchesTheSearchByAuthor() {
        Product first = new Book(10, "Унесенные ветром", 670, "Маргарет Митчелл");

        boolean actual = first.matches("Маргарет Митчелл");

        assertTrue(actual);
    }
}