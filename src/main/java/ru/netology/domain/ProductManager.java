package ru.netology.domain;

public class ProductManager {
    private ProductRepository repository;

    public Product[] getItems() {
        return repository.findAll();
    }

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product item) {
        repository.save(item);
    }

    public void removeById(int id) {repository.removeById(id);}

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;

    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (book.getAuthor().equalsIgnoreCase(search)) {
                return true;
            }
        }
        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (smartphone.getProducer().equalsIgnoreCase(search)) {
                return true;
            }
        }
        return false;
    }


//    public Product[] getAll() {
//        int length;
//        Product[] items = repository.findAll();
//        if (items.length < countProduct) length = items.length;
//        else length = countProduct;
//        Product[] result = new Product[length];
//        // перебираем массив в прямом порядке
//        // но кладём в результаты в обратном
//        for (int i = 0; i < result.length; i++) {
//            int index = items.length - i - 1;
//            result[i] = items[index];
//        }
//        return result;
//    }

}
