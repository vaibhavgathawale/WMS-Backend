package com.wms.repository;

import com.wms.entity.ProductEntity;
import com.wms.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserEntity,Integer> {

    @Query("SELECT u FROM UserEntity u WHERE u.User_Name = :UserName AND u.Password = :Password")
    public List<UserEntity> findByUserNamePassword(String UserName,String Password);

}
