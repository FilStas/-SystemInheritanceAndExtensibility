package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    private ProductRepository repository = new ProductRepository();
    private Book first = new Book(10, "Унесенные ветром", 670, "Маргарет Митчелл");
    private Book second = new Book(11, "Мастер и Маргарита", 760, "Михаил Булгаков");
    private Book third = new Book(12, "Грозовой перевал", 540, "Эмили Бронте");
    private Book fourth = new Book(13, "Шерлок Холмс", 870, "Артур Конан Дойл");
    private Book fifth = new Book(14, "Вино из одуванчиков", 450, "Рэй Брэдбери");

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
    }

    @Test
    public void shouldSaveOneItem() {
        Product[] expected = new Product[]{first, second, third, fourth, fifth};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveToId() {
        int productId = 13;
        repository.removeById(productId);

        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{first, second, third, fifth};
        assertArrayEquals(actual, expected);
    }

}