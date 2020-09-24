package cz.dostalma.monolithicshop.facade;

import cz.dostalma.monolithicshop.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductFacadeImpl implements ProductFacade {

    // TEST map for products - to be replaced by db persistence
    private final Map<Long, Product> products = new HashMap<>();
    private static long productIDCounter = 0;

    public ProductFacadeImpl() {
        Product product = new Product.ProductBuilder()
                .withId(++productIDCounter)
                .withName("Apple")
                .withPrice(3.99)
                .build();
        products.put(product.getId(), product);
    }

    // @TODO replace by db persistence / product service logic
    @Override
    public Long createProduct(Product product) {
        product.setId(++productIDCounter);
        return product.getId();
    }

    // @TODO replace by db persistence / product service logic
    @Override
    public Product getProductById(Long id) {
        return products.get(id);
    }

    // @TODO replace by db persistence / product service logic
    @Override
    public List getAllProducts() {
        List<Product> resultList = products.values().stream()
                .filter(x -> x != null)
                .collect(Collectors.toList());
        return resultList;
    }

    // @TODO replace by db persistence / product service logic
    @Override
    public void updateProduct(Product product) {
        products.replace(product.getId(), product);
    }

    // @TODO replace by db persistence / product service logic
    @Override
    public void deleteProduct(Product product) {
        products.remove(product.getId());
    }
}
