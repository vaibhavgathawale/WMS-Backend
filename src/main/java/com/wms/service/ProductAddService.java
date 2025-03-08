package com.wms.service;

import com.wms.entity.ProductAddEntity;
import com.wms.repository.ProductAddRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductAddService {
        @Autowired
       private ProductAddRepo repo;

    public String saveDetails(ProductAddEntity pp) {
          // logic
          repo.save(pp);
          return "Product Save Successfully !";

    }
}
