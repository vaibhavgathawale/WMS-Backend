package com.wms.service;

import com.wms.entity.ProductEntity;
import com.wms.exception.ProductExistException;
import com.wms.exception.ProductNotFoundException;
import com.wms.repository.ProductRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    Logger logger = LoggerFactory.getLogger(ProductService.class);
    @Autowired
    private ProductRepo repo;

    public String saveProduct(ProductEntity product) {

        String product_name = null;
        String product_flavour = null;
        int product_ml = 0;
        try {
            product_name = product.getProduct_Name();
            product_flavour = product.getFlavours();
            product_ml = product.getmL();

            List<ProductEntity> prodList = repo.findbyNameFlavourMl(product_name,product_flavour,product_ml);

            if(prodList.isEmpty()) {
                repo.save(product);
                logger.info("Product Save Successfully");
                return "Record Save Successfully";
            } else {
                logger.warn("Product Already Present");
                throw new ProductExistException("Product With Name : "+ product_name + ", Flavours : "+product_flavour+" AND ML: "+product_ml+ " Already Present");
            }
        } catch (ProductExistException e) {
            throw new ProductExistException("Product With Name : "+ product_name + ", Flavours : "+product_flavour+" AND ML: "+product_ml+ " Already Present");
        }
    }

    public List<ProductEntity> getProductList() {

        List<ProductEntity> prodlist = new ArrayList<ProductEntity>();

        try {
            prodlist = repo.findAll();
            logger.info("Get Product Details List");
        } catch(RuntimeException e) {
            logger.warn("Product Get Details Runtime Exception");
            e.printStackTrace();
        }
        return prodlist;
    }

    public ProductEntity getDetails(int id) {

        try {
            Optional<ProductEntity> prod = repo.findById(id);
            if (prod.isPresent()) {
                logger.info("Get Product Detail");
                return prod.get();
            } else {
                logger.warn("Throw Product Not Found Exception in Get Details Method");
                throw new ProductNotFoundException("Product With Id "+ id + " Not Found");
            }
        } catch (ProductNotFoundException e) {
            throw new ProductNotFoundException("Product Not Found  with id = "+id);
        }
    }

    public String deleteProduct(int id) {

        try {
            Optional<ProductEntity> prod = repo.findById(id);
            if (prod.isPresent()) {
                repo.deleteById(id);
                logger.info("Product Deleted Successfully");
                return "Product Deleted Successfully";
            } else {
                logger.warn("Throw Product Not Found Exception in Delete Product Method");
                throw new ProductNotFoundException("Product With Id " + id + " Not Found");
            }
        } catch (ProductNotFoundException e) {
            throw new ProductNotFoundException("Product Not Found  with id = "+id);
        }
    }
}
