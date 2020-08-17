package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Book;
import ru.netology.domain.Game;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductManagerTest {
    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductManager manager;
    private Book first = new Book(10, "Унесенные ветром", 670, "Маргарет Митчелл");
    private Book second = new Book(11, "Мастер и Маргарита", 760, "Михаил Булгаков");
    private Book third = new Book(12, "Грозовой перевал", 540, "Эмили Бронте");
    private Book fourth = new Book(13, "Шерлок Холмс", 870, "Артур Конан Дойл");
    private Book fifth = new Book(14, "Вино из одуванчиков", 450, "Рэй Брэдбери");
    private Smartphone sixth = new Smartphone(15, "iPhone XR", 45000, "Apple");
    private Smartphone seventh = new Smartphone(16, "Huawei P30", 31000, "Huawei");
    private Smartphone eighth = new Smartphone(17, "Redmi Note 8T", 13000, "Redmi");
    private Game ninth = new Game(18, "Sega", 15000);

    @Test
    void shouldFindAndAddABookByName() {
        Product[] returned = new Product[]{first};
        doReturn(returned).when(repository).findAll();

        manager.add(first);
        Product[] expected = new Product[]{first};
        Product[] actual = manager.searchBy("Унесенные ветром");

        assertArrayEquals(expected, actual);
        verify(repository).save(any());
        verify(repository).findAll();

    }

    @Test
    void shouldFindAndAddABookByAuthor() {
        Product[] returned = new Product[]{third};
        doReturn(returned).when(repository).findAll();

        manager.add(third);
        Product[] expected = new Product[]{third};
        Product[] actual = manager.searchBy("Эмили Бронте");

        assertArrayEquals(expected, actual);
        verify(repository).save(any());
        verify(repository).findAll();

    }

    @Test
    void shouldFindAll(){

    }

    @Test
    void shouldFindAndAddASmartphoneByName() {
        Product[] returned = new Product[]{seventh};
        doReturn(returned).when(repository).findAll();

        manager.add(seventh);
        Product[] expected = new Product[]{seventh};
        Product[] actual = manager.searchBy("Huawei P30");

        assertArrayEquals(expected, actual);
        verify(repository).save(any());
        verify(repository).findAll();
    }

    @Test
    void shouldCheckIfTheProductMatchesTheSearchQuery() {
        manager.add(fifth);
        boolean actual = manager.matches(fifth, "Вино из одуванчиков");

        assertTrue(actual);
        verify(repository).save(any());
    }

    @Test
    void shouldCheckWhetherTheProductMatchesTheAuthorField() {
        manager.add(second);
        boolean actual = manager.matches(second, "Михаил Булгаков");

        assertTrue(actual);
        verify(repository).save(any());
    }

    @Test
    void shouldCheckWhetherTheProductMatchesTheManufacturerField() {
        manager.add(sixth);
        boolean actual = manager.matches(sixth, "Apple");

        assertTrue(actual);
        verify(repository).save(any());
    }

    @Test
    void shouldCheckWhetherTheProductMatchesTheManufacturer() {
        manager.add(ninth);
        boolean actual = manager.matches(ninth,"Sega");

        assertFalse(actual);
        verify(repository).save(any());
    }

}