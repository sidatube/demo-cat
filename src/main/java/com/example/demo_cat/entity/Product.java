package com.example.demo_cat.entity;

import com.example.demo_cat.annotation.Column;
import com.example.demo_cat.annotation.Id;
import com.example.demo_cat.annotation.Table;

import java.util.Objects;

@Table(name = "products")
public class Product {
    @Id(AutoIncrement = true)
    @Column(name = "id", type = "INT")
    private int id;
    @Column(name = "name", type = "VARCHAR(250)")
    private String name;
    @Column(name = "thumbnail", type = "TEXT")
    private String thumbnail;
    @Column(name = "price", type = "DOUBLE")
    private double price;
    @Column(name = "status", type = "INT")
    private int status;

    public Product(String name, String thumbnail, double price, int status) {
        this.name = name;
        this.thumbnail = thumbnail;
        this.price = price;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Product(String name, String thumbnail, double price) {
        this.name = name;
        this.thumbnail = thumbnail;
        this.price = price;
        this.status=1;
    }

    public Product(int id, String name, String thumbnail, double price, int status) {
        this.id = id;
        this.name = name;
        this.thumbnail = thumbnail;
        this.price = price;
        this.status = status;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", price=" + price +
                ", status=" + status +
                '}';
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

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
