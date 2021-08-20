package com.bjpowernode.pojo;

import java.io.Serializable;
import java.util.List;

// 一对多查询：查询类别（一）的同时，将类别下的商品（多）查询出来
public class Type implements Serializable {
    private String id;
    private String name;
    // 在一的一方中添加多的一方的集合对象
    private List<Product> products; // 关联对象

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}
