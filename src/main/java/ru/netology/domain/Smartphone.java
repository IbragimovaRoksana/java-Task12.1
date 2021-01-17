package ru.netology.domain;

public class Smartphone extends Product {
    private String producer;

    @Override
    public String toString() {
        return "Smartphone{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", price=" + super.getPrice() + '\'' +
                ", producer='" + producer + '\'' +
                '}';
    }

    public Smartphone() {
        super();
    }

    public boolean matches(String search) {
        return super.matches(search) || producer.equalsIgnoreCase(search);
    }

    public Smartphone(int id, String name, int price, String producer) {
        super(id, name, price);
        this.producer = producer;
    }

    public String getProducer() {
        return producer;
    }
}
