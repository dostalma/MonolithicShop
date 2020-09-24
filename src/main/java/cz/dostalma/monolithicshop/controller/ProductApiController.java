package cz.dostalma.monolithicshop.controller;

import cz.dostalma.monolithicshop.facade.ProductFacade;
import cz.dostalma.monolithicshop.model.Product;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductApiController {

    private Logger logger = Logger.getLogger(ProductApiController.class);

    @Autowired
    protected ProductFacade productFacade;

    /**
     * GER request to return a list of products
     *
     * @return List of products
     */
    @RequestMapping(value = "/api/products", method = RequestMethod.GET)
    public List<Product> findAll() {
        logger.info("Request to retrieve all products");
        return productFacade.getAllProducts();
    }

    /**
     * GET Request with an ID parameter returns a single product if existing
     *
     * @param id of the product to retrieve
     * @return Found product if existing
     */
    @GetMapping(value = "/{id}")
    public Product findById(@PathVariable("id") Long id) {
        logger.info("Request to retrieve a product with id: " + id);
        return productFacade.getProductById(id);
    }

    /**
     * POST Request to create a product
     *
     * @param product payload of a Product object
     * @return List of products
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@RequestBody Product product) {
        logger.info("Request to create an product: " + product.toString());
        return productFacade.createProduct(product);
    }


    /**
     * PUT Request to update a product
     *
     * @param id of Product to be updated
     * @param product payload of a Product object
     */
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") Long id, @RequestBody Product product) {
        logger.info("Request to update an product: " + product.toString() + "with id: " + id);
        product.setId(id);
        productFacade.updateProduct(product);
    }

    /**
     * DELETE Request to delete an product
     *
     * @param id of product to delete
     */
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        logger.info("Request to delete a product with id: " + id);
        productFacade.deleteProduct(productFacade.getProductById(id));
    }
}
