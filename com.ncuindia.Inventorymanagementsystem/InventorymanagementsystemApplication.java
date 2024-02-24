package com.ncuindia.Inventorymanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class InventoryManagementSystemApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(InventoryManagementSystemApplication.class, args);
		ProductRepository productrepository = context.getBean(ProductRepository.class);
		productrepository.findById(1);
		
		Product p=new Product();
		
		InventoryService inventoryservice = context.getBean(InventoryService.class);
		inventoryservice.addProduct(p);
		inventoryservice.updateProduct(p);
		inventoryservice.getProductById(2);
	
	}

}
