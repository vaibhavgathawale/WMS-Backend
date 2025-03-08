package com.wms.entity;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "User_Id")
    private int User_Id;
    @Column(name = "User_Name")
    private String User_Name;
    @Column(name = "Password")
    private String Password;

    public UserEntity() {

    }
    public UserEntity(String user_Name, String password) {
        User_Name = user_Name;
        Password = password;
    }
    public int getUser_Id() {
        return User_Id;
    }

    public void setUser_Id(int user_Id) {
        User_Id = user_Id;
    }

    public String getUser_Name() {
        return User_Name;
    }

    public void setUser_Name(String user_Name) {
        User_Name = user_Name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "User_Id=" + User_Id +
                ", User_Name='" + User_Name + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
