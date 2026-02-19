package com.example.ch8_ex5.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import com.example.ch8_ex5.model.Product;

// 새 제품을 추가하고, 가져오는 두 가지 메서드를 정의하는 Service Class
@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public List<Product> findAll() {
        return products;
    }
}