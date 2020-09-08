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

    @Test
    void shouldCheckIfTheBookMatchesTheSearchByAuthor() {
        Product second = new Book(11, "Мастер и Маргарита", 760, "Михаил Булгаков");
        Product third = new Book(12, "Грозовой перевал", 540, "Эмили Бронте");
        Product fourth = new Book(13, "Шерлок Холмс", 870, "Артур Конан Дойл");
        Product fifth = new Book(14, "Вино из одуванчиков", 450, "Рэй Брэдбери");
        Product first = new Book(10, "Унесенные ветром", 670, "Маргарет Митчелл");

        boolean actual = first.matches("Маргарет Митчелл");

        assertTrue(actual);
    }
}