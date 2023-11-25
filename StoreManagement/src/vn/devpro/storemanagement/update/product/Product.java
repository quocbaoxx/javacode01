package vn.devpro.storemanagement.update.product;

import java.util.Scanner;

import vn.devpro.storemanagement.update.category.CategoryManagement;

public class Product {
	private int id;
	private int categoryId;
	private String name;
	private double price;
	private double amount;
	
	public void display() {
		System.out.printf("%6d %-25s %-30s %,15.2f %,12.2f%n", 
				this.id, CategoryManagement.getNameById(categoryId),this.name, this.price,this.amount);
	}
	static Scanner sc = new Scanner(System.in);
	
	
	
	
	
	
	
	
	
	
 
	public Product() {
		super();
	}

	public Product(int id, int categoryId, String name, double price, double amount) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.name = name;
		this.price = price;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
