package com.ncuindia.Inventorymanagementsystem;
import java.util.List;

public interface ProductRepository {
    Product findById(int id);
    List<Product> findAll();
    void save(Product product);
    void update(Product product);
    void deleteById(Long id);
}


