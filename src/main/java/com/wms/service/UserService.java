package com.wms.service;

import com.wms.entity.UserEntity;
import com.wms.exception.UserNotFoundException;
import com.wms.repository.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;
    Logger logger = LoggerFactory.getLogger(UserService.class);

    public String checkCredentials(UserEntity user) {

        String UserName = null;
        String Password = null;

        try {
            UserName = user.getUser_Name();
            Password = user.getPassword();

            List<UserEntity> UserList = userRepo.findByUserNamePassword(UserName,Password);

            if (UserList != null && UserList.isEmpty()) {
                logger.info("Valid User");
                return "User Login Successfully";
            } else {
                logger.warn("User Not Present");
                throw new UserNotFoundException("Invalid UserName And Password");
            }
        } catch (UserNotFoundException e) {
            throw new UserNotFoundException("Invalid UserName And Password");
        }
    }
}