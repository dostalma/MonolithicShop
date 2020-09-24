package cz.dostalma.monolithicshop.controller;

import cz.dostalma.monolithicshop.facade.ProductFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.apache.log4j.Logger;

@Controller
public class ProductController {

    private Logger logger = Logger.getLogger(ProductController.class);

    @Autowired
    protected ProductFacade productFacade;

    /**
     * Request for base url returns a list of products
     *
     * @return List of products
     */
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String showProducts(Model model) {
        logger.info("Request to retrieve all products");

        model.addAttribute("products", productFacade.getAllProducts());
        return "productmng";
    }

    /**
     * Request for base url returns a list of products
     *
     * @return List of products
     */
    @RequestMapping(value = "/todo", method = RequestMethod.GET)
    public String todo(Model model) {
        return "todomng";
    }
}
