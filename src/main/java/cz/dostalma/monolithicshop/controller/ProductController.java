package cz.dostalma.monolithicshop.controller;

import cz.dostalma.monolithicshop.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

@Controller
public class ProductController {

    private Logger logger = Logger.getLogger(ProductController.class);

    /**
     * Request for base url returns a list of products
     *
     * @return List of products
     */
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String showProducts(Model model) {
        logger.info("Request to retrieve all products");

        // DEBUG test products -- to be replaced
        List<Product> list = new ArrayList<>();
        Product product = new Product.ProductBuilder()
                .withId(1l)
                .withName("Apple")
                .withPrice(3.99)
                .build();
        list.add(product);

        model.addAttribute("products", list);
        return "productmng";
    }
}
