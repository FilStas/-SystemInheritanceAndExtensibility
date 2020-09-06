package ru.netology.domain;

import java.util.Objects;

public class Book extends Product {
    Book book = new Book();
    private String author;

    public Book() {
        super();
    }

    public Book(String author) {
        this.author = author;
    }

    public Book(int id, String name, int cost, String author) {
        super(id, name, cost);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
    @Override
    public boolean matches(String search) {
        return super.matches(search) || book.getAuthor().equalsIgnoreCase(search);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), author);
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
