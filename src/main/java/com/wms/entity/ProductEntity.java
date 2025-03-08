package com.wms.entity;

import javax.persistence.*;

@Entity
@Table(name = "Product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private int id;
    @Column(name = "Sr_no")
    private int sr;
    @Column(name = "Product_Name")
    private String product_Name; //product
    @Column(name = "Price")
    private Long price;
    @Column(name = "ML")
    private int mL;
    @Column(name = "Quantity")
    private int quantity;
    @Column(name = "Flavours")
    private String flavours;

    public ProductEntity(){}

    public ProductEntity(int sr, String product_Name, Long price, int mL, int quantity, String flavours) {
        this.sr = sr;
        this.product_Name = product_Name;
        this.price = price;
        this.mL = mL;
        this.quantity = quantity;
        this.flavours = flavours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSr() {
        return sr;
    }

    public void setSr(int sr) {
        this.sr = sr;
    }

    public String getProduct_Name() {
        return product_Name;
    }

    public void setProduct_Name(String product_Name) {
        this.product_Name = product_Name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public int getmL() {
        return mL;
    }

    public void setmL(int mL) {
        this.mL = mL;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getFlavours() {
        return flavours;
    }

    public void setFlavours(String flavours) {
        this.flavours = flavours;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", sr=" + sr +
                ", product_Name='" + product_Name + '\'' +
                ", price=" + price +
                ", mL=" + mL +
                ", quantity=" + quantity +
                ", flavours='" + flavours + '\'' +
                '}';
    }
}
