package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    Product countMonteCristo = new Book(413, "count Monte Cristo", 1200, "A. Dyuma");
    Product theWitcher = new Book(449, "The Witcher", 1900, "A. Sapkovskiy");
    Product onegin = new Book(404, "Onegin", 780, "A. Pushkin");
    Product gameOfTrones = new Book(404, "Game Of Trones", 2300, "J. Martin");
    Product lordOfTheRings = new Book(490, "Lord Of The Rings", 2400, "J.R. Tolkin");
    Product samsung = new Book(400, "Samsung in the life", 540, "Samseong Gurub");
    Product samsungPhone = new Smartphone(567, "SamsungGalaxyS9Plus", 30000, "Samseong Gurub");
    Product xiaomiF2 = new Smartphone(577, "XiaomiPocoF2Pro", 40000, "Xiaomi Corporation");
    Product xiaomiRedmi9 = new Smartphone(526, "XiaomiRedmi9", 10000, "Xiaomi Corporation");
    Product iPhone = new Smartphone(510, "Iphone6", 20000, "Apple Computer");
    Product loloPhone = new Smartphone();
    Product loloBook = new Book();

    @Test
    void shouldAdd() {
        manager.add(countMonteCristo);
        manager.add(samsungPhone);
        Product[] expected = new Product[]{countMonteCristo, samsungPhone};
        Product[] actual = manager.getItems();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchOneElementByAuthor() {
        manager.add(countMonteCristo);
        manager.add(theWitcher);
        manager.add(onegin);
        manager.add(gameOfTrones);
        manager.add(lordOfTheRings);
        manager.add(samsung);
        manager.add(samsungPhone);
        manager.add(xiaomiF2);
        manager.add(xiaomiRedmi9);
        manager.add(iPhone);


        Product[] expected = new Product[]{lordOfTheRings};
        Product[] actual = manager.searchBy("J.R. Tolkin");
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldSearchOneElementByName() {
        manager.add(countMonteCristo);
        manager.add(theWitcher);
        manager.add(onegin);
        manager.add(gameOfTrones);
        manager.add(lordOfTheRings);
        manager.add(samsung);
        manager.add(samsungPhone);
        manager.add(xiaomiF2);
        manager.add(xiaomiRedmi9);
        manager.add(iPhone);


        Product[] expected = new Product[]{samsung};
        Product[] actual = manager.searchBy("Samsung in the life");
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldSearchOneElementByNamePhone() {
        manager.add(countMonteCristo);
        manager.add(theWitcher);
        manager.add(onegin);
        manager.add(gameOfTrones);
        manager.add(lordOfTheRings);
        manager.add(samsung);
        manager.add(samsungPhone);
        manager.add(xiaomiF2);
        manager.add(xiaomiRedmi9);
        manager.add(iPhone);


        Product[] expected = new Product[]{samsungPhone};
        Product[] actual = manager.searchBy("SamsungGalaxyS9Plus");
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldSearchBySeveralElements() {
        manager.add(countMonteCristo);
        manager.add(theWitcher);
        manager.add(onegin);
        manager.add(gameOfTrones);
        manager.add(lordOfTheRings);
        manager.add(samsung);
        manager.add(samsungPhone);
        manager.add(xiaomiF2);
        manager.add(xiaomiRedmi9);
        manager.add(iPhone);


        Product[] expected = new Product[]{samsung, samsungPhone};
        Product[] actual = manager.searchBy("Samseong Gurub");
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldSearchByNoneElement() {
        manager.add(countMonteCristo);
        manager.add(theWitcher);
        manager.add(onegin);
        manager.add(gameOfTrones);
        manager.add(lordOfTheRings);
        manager.add(samsung);
        manager.add(samsungPhone);
        manager.add(xiaomiF2);
        manager.add(xiaomiRedmi9);
        manager.add(iPhone);


        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("XiaomiPocoF1");
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldRemoveById() {
        manager.add(gameOfTrones);
        manager.add(lordOfTheRings);
        manager.add(samsungPhone);
        manager.add(xiaomiF2);

        Product[] expected = new Product[]{lordOfTheRings, samsungPhone, xiaomiF2};
        manager.removeById(404);
        Product[] actual = manager.getItems();
        assertArrayEquals(expected, actual);
    }
}