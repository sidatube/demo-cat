package com.example.demo_cat.entity;

import com.example.demo_cat.annotation.Column;
import com.example.demo_cat.annotation.Id;
import com.example.demo_cat.annotation.Table;

@Table(name = "staffs")
public class NhanVien {
    @Id(AutoIncrement = true)
    @Column(name = "id", type = "INT")
    private int id;
    @Column(name = "name", type = "VARCHAR(250)")
    private String name;
    @Column(name = "email", type = "VARCHAR(250)")
    private String email;
    @Column(name = "address", type = "VARCHAR(250)")
    private String address;
    @Column(name = "tel", type = "VARCHAR(250)")
    private String tel;
    @Column(name = "age", type = "INT")
    private int age;
    @Column(name = "status", type = "INT")
    private int status;

    public NhanVien() {
    }

    public NhanVien(String name, String email, String address, String tel, int age) {
        this(name, email, address, tel, age, 1);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public NhanVien(String name, String email, String address, String tel, int age, int status) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.tel = tel;
        this.age = age;
        this.status = status;
    }

    public NhanVien(int id, String name, String email, String address, String tel, int age, int status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.tel = tel;
        this.age = age;
        this.status = status;
    }
}
