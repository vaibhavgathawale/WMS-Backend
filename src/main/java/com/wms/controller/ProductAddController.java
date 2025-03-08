package com.wms.controller;

import com.wms.entity.ProductAddEntity;
import com.wms.repository.ProductAddRepo;
import com.wms.service.ProductAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("**")
public class ProductAddController {
    @Autowired
    private ProductAddService ser;

    @PostMapping("/savepp")
    public String savePro(@RequestBody ProductAddEntity pp){



        return ser.saveDetails(pp);
    }
}
