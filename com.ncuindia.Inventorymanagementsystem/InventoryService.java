package com.ncuindia.Inventorymanagementsystem;
import java.util.List;
public interface InventoryService {

	    void addProduct(Product product);
	    void updateProduct(Product product);
	    Product getProductById(int id);
	    List<Product> getAllProducts();
	}
