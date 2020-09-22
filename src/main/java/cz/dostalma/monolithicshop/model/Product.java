package cz.dostalma.monolithicshop.model;

public class Product {

    private static final long serialVersionUID = 666L;

    private long id;

    private String name;

    private Double price;

    public Product() {
    }

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public static class ProductBuilder {

        private Product product;

        public ProductBuilder() { product = new Product(); }

        public ProductBuilder withId(long id) {
            product.id = id;
            return this;
        }

        public ProductBuilder withName(String name) {
            product.name = name;
            return this;
        }

        public ProductBuilder withPrice(Double price) {
            product.price = price;
            return this;
        }

        public Product build() {
            return product;
        }

    }

}
