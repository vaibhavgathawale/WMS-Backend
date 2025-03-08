package com.wms.controller;

import com.wms.entity.ProductEntity;
import com.wms.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin("**")
public class ProductController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @PostMapping("/saveProduct")
    public String saveProductDetails(@RequestBody ProductEntity product) {
        logger.info("Product Service Save Method Call");
        return productService.saveProduct(product);
    }

    @GetMapping("/listProduct")
    public List<ProductEntity> getProductList() {

        logger.info("Product Service Get Product List Method Call");
        return productService.getProductList();
    }

    @GetMapping("/product/{id}")
    public ProductEntity getProductDetails(@PathVariable int id) {
        logger.info("Product Service Get Product Details Method Call");
        return productService.getDetails(id);
    }

   @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id) {
       logger.info("Product Service Delete Product Method Call");
        return productService.deleteProduct(id);
    }

}
