package vn.devpro.storemanagement.sale;

import vn.devpro.storemanagement.update.product.Product;
import vn.devpro.storemanagement.update.product.ProductManagement;

public class CartProduct {//Hang trong gio
	private int productId;
	private double amount;
	
//	Hien thi hang trong gio
	public void display() {
		Product product = ProductManagement.getProductByIf(productId);
		
		System.out.printf("%-30s %,15.2f %,12.2f %,15.2f%n",
				product.getName(),product.getPrice(),this.amount, this.amount*product.getPrice()
				);
	}
	
	public double total() {
		Product product = ProductManagement.getProductByIf(productId);
		return this.amount*product.getPrice();
	}
	
	
	
	public CartProduct(int productId, double amount) {
		super();
		this.productId = productId;
		this.amount = amount;
	}
	public CartProduct() {
		super();
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
}
