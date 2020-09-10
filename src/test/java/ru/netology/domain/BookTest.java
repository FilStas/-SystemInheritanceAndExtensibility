package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void shouldCheckIfTheBookMatchesTheSearchByName() {
        Product first = new Book(10, "Унесенные ветром", 670, "Маргарет Митчелл");

        boolean actual = first.matches("Унесенные ветром");

        assertTrue(actual);
    }

    @Test
    void shouldCheckSearchForBookIfThereIsAMistakeInName() {
        Product first = new Book(10, "Унесенные ветром", 670, "Маргарет Митчелл");

        boolean actual = first.matches("Унисенные ветром");

        assertFalse(actual);
    }
}