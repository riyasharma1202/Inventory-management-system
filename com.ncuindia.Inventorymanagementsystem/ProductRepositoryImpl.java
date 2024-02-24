package com.ncuindia.Inventorymanagementsystem;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductRepositoryImpl implements ProductRepository {
    private Map<Integer, Product> products = new HashMap<>();
    private int idSequence = 1;

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public List<Product> findAll() {
        return products.values().stream().collect(Collectors.toList());
    }

    @Override
    public void save(Product product) {
        product.setId(idSequence++);
        products.put(product.getId(), product);
    }

    @Override
    public void update(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void deleteById(Long id) {
        products.remove(id);
    }
}
