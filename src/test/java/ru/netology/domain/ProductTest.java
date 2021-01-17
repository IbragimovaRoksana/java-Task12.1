package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void shouldMatchesProduct() {
        Product Product1=new Product(444, "Gugen", 8800);

        boolean expected=true;
        boolean actual=Product1.matches("Gugen");
        assertEquals(expected,actual);
    }

    @Test
    void shouldMatchesNameBook() {
        Product Product1=new Book(444, "Gugen", 8800, "Gugen23");

        boolean expected=true;
        boolean actual=Product1.matches("Gugen");
        assertEquals(expected,actual);

    }

    @Test
    void shouldMatchesAuthorBook() {
        Product Product1 = new Book(444, "Gugen", 8800, "Gugen23");
        boolean expected = true;
        boolean actual = Product1.matches("Gugen23");
        assertEquals(expected, actual);
    }

    @Test
    void shouldMatchesNameSmartphone() {
        Product Product1 = new Smartphone(444, "iiphone", 8800, "ii industrise");

        boolean expected = true;
        boolean actual = Product1.matches("iiphone");
        assertEquals(expected, actual);
    }

    @Test
    void shouldMatchesProducerSmartphone() {
        Product Product1 = new Smartphone(444, "iiphone", 8800, "ii industrise");

        boolean expected = true;
        boolean actual = Product1.matches("ii industrise");
        assertEquals(expected, actual);
    }

}