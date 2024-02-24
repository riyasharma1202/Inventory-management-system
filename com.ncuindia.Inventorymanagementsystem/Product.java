package com.ncuindia.Inventorymanagementsystem;

public class Product {
	
    private int id;
    private String name;
    private int quantity;
    private double price;

    // Constructors, getters, setters
   

        // Constructor
        public Product() 
        {
        }

        public Product(int id, String name, int quantity, double price) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

		// Getters
        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getPrice() {
            return price;
        }

        // Setters
        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public void setPrice(double price) {
            this.price = price;
        }

		@Override
		public String toString() {
			return "Product [id=" + id + ", name=" + name + ", quantity=" + quantity + ", price=" + price + "]";
		}
              
}





