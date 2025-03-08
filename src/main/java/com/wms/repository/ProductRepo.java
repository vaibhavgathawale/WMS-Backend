package com.wms.repository;

import com.wms.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity,Integer> {

    @Query("SELECT p FROM ProductEntity p WHERE p.product_Name = :product_name AND p.flavours = :flavour AND p.mL = :ml")
    public List<ProductEntity> findbyNameFlavourMl(String product_name, String flavour, int ml);

}
