package com.wms.controller;

import com.wms.entity.UserEntity;
import com.wms.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController

public class UserController {

    @Autowired
    private UserService userService;
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/checking")
    public String checkUserCredentials(@RequestBody UserEntity user) {
        logger.info("User Service checkUserCredentials Method Call");
        return userService.checkCredentials(user);
    }

}
