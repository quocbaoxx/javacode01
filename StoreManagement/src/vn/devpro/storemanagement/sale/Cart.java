package vn.devpro.storemanagement.sale;

import java.util.List;
import java.util.Scanner;

import vn.devpro.storemanagement.update.costomer.CustomerManagement;
import vn.devpro.storemanagement.update.product.ProductManagement;

import java.util.ArrayList;

public class Cart {
	private int id;
	private int customerId;
	
	static Scanner sc = new Scanner(System.in);
	public double cartTotal() {
		double total = 0;
		for (CartProduct cartProduct : list) {
			total+=cartProduct.total();
		}
		return total;
	}
	public void display() {//Hien thi gio hang
		System.out.println("\n-------GIO HANG CUA BAN-------");
		System.out.println("\tTen khach hang: "+CustomerManagement.getNameById(customerId));
		System.out.println("\tGio hang co "+list.size()+" loai hang hoa");
		System.out.printf("%3s %-30s %-15s %-12s %-15s%n",
				"STT","Ten Hang hoa","Don gia","So Luong","Thanh tien"
				);
		for (int i = 0; i < list.size(); i++) {
			list.get(i).display();
		}
		System.out.printf("\t\tCong thanh tien: %,.2f%n", cartTotal());
	}

	
	public void add() { //Them mot hang hoa vao gio hang
		System.out.println("\n--------THEM HANG HOA VAO GIO HANG----------");
		
		System.out.print("Nhap ma hang (id) muon mua: ");
		int productId = Integer.parseInt(sc.nextLine()); 
		
		//Kiem tra xem productId co trong danh sach hang ban hay khong
		int index = ProductManagement.indexOfProduct(productId);
		if (index == -1) {
			System.out.println("Hang hoa khong co trong ds ban, xin chon lai");
			return;
		}
		
		//Co thi nhap so luong can mua
		System.out.print("Nhap so luong muon mua: ");
		double amount = Double.parseDouble(sc.nextLine());
		if (amount <= 0) {
			System.out.println("So luong mua phai lon hon 0");
			return;
		}
		
		//Tim xem hang dinh mua co trong gio chua
		int cartIndex = indexOfCartProduct(productId);
		if (cartIndex != -1) { //Hang dinh mua da co trong gio
			amount += list.get(cartIndex).getAmount(); //Cong so luong trong gio voi so luong moi chon them
		}
		
		//Kiem tra tong so luong mua co vuot qua tong so luong dang co ban
		if (amount > ProductManagement.getList().get(index).getAmount()) {
			System.out.println("So luong can mua vuot qua kha nang, xin chon lai");
			return;
		}
		
		//Them hang vao gio: 2 truong hop
		if (cartIndex != -1) { //Hang da co trong gio
			list.get(cartIndex).setAmount(amount); //Set lai so luong moi
		}
		else { //hang chua co trong gio
			list.add(new CartProduct(productId, amount)); //Them hang moi vao gio
		}
		System.out.println("Them hang moi thanh cong!");
	}
	
	public void update() { // Sua thong tin hang hoa trong gio
		System.out.println("\n--------SUA THONG TIN HANG TRONG GIO HANG----------");
		
		System.out.print("Nhap ma hang (id) muon SUA: ");
		int productId = Integer.parseInt(sc.nextLine()); 
		
		//Kiem tra hang co trong gio khong?
		int cartIndex = indexOfCartProduct(productId);
		if (cartIndex == -1) { //Khong co
			System.out.println("Hang khong co trong gio");
			return;
		}
		//Co
		System.out.print("Nhap so luong moi: ");
		double amount = Double.parseDouble(sc.nextLine());
		if (amount <= 0) {
			System.out.println("So luong mua phai lon hon 0");
			return;
		}
		//Kiem tra so luong khong vuot so luong ban
		int index = ProductManagement.indexOfProduct(productId);
		if (amount > ProductManagement.getList().get(index).getAmount()) {
			System.out.println("So luong can mua vuot qua kha nang, xin chon lai");
			return;
		}
		//Thay so luong cu bang so luong moi
		list.get(cartIndex).setAmount(amount);
		System.out.println("Sua thong tin hang hoa thanh cong!");
	}
	
	public void remove() { //Xoa hang khoi gio

		System.out.println("\n--------XOA HANG TRONG GIO HANG----------");
		
		System.out.print("Nhap ma hang (id) muon XOA: ");
		int productId = Integer.parseInt(sc.nextLine()); 
		
		//Kiem tra hang co trong gio khong?
		int cartIndex = indexOfCartProduct(productId);
		if (cartIndex == -1) { //Khong co
			System.out.println("Hang khong co trong gio");
			return;
		}
		list.remove(cartIndex);
		System.out.println("Xoa hang trong gio thanh cong!");
	}
	
	
	//Phuong thuc kiem tra mot hang hoa da ton tai trong gio chua
	public int indexOfCartProduct(int productId) {
		for (int index = 0; index < list.size(); index++) {
			if (list.get(index).getProductId() == productId) {
				return index;
			}
		}
		return -1;
	}
	
	
	
	
	private List<CartProduct> list = new ArrayList<CartProduct>();
	public Cart(int id, int customerId, List<CartProduct> list) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.list = list;
	}
	public Cart() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public List<CartProduct> getList() {
		return list;
	}
	public void setList(List<CartProduct> list) {
		this.list = list;
	}
	
}
