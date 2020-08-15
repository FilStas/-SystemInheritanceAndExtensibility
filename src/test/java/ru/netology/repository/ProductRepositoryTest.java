package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book first = new Book(10, "Унесенные ветром", 670, "Маргарет Митчелл");
    private Book second = new Book(11, "Мастер и Маргарита", 760, "Михаил Булгаков");
    private Book third = new Book(12, "Грозовой перевал", 540, "Эмили Бронте");
    private Book fourth = new Book(13, "Шерлок Холмс", 870, "Артур Конан Дойл");
    private Book fifth = new Book(14, "Вино из одуванчиков", 450, "Рэй Брэдбери");
    private Smartphone sixth = new Smartphone(15, "iPhone XR", 45000, "Apple");
    private Smartphone seventh = new Smartphone(16, "Huawei P30", 31000, "Huawei");
    private Smartphone eighth = new Smartphone(17, "Redmi Note 8T", 13000, "Redmi");



    @Test
    void shouldSaveOneItem() {
        repository.save(first);

        Product[] expected = new Product[] {first};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSaveDifferentProducts() {
        repository.save(second);
        repository.save(sixth);

        Product[] expected = new Product[] {second, sixth};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveToId() {
        repository.save(fourth);
        repository.save(seventh);
        int productId = 16;
        repository.removeById(productId);

        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{fourth};
        assertArrayEquals(actual, expected);
    }
}