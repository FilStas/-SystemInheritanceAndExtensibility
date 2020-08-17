package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookTest {
    Book book = new Book();

    @Test
    void shouldUseEqualsBook() {
        Product first = new Book(10, "Унесенные ветром", 670, "Маргарет Митчелл");
        Product second = new Book(10, "Унесенные ветром", 670, "Маргарет Митчелл");

        assertEquals(first, second);
    }

//    @Test
//    void setAuthor() {
//        Book first = new Book("Маргарет Митчелл");
//        book.setAuthor("Маргарет Митчелл");
//
//        assertEquals(first, book.getAuthor());
//    }
}