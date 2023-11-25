package vn.devpro.storemanagement.update.product;

import java.util.List;
import java.util.Scanner;


import vn.devpro.storemanagement.update.category.CategoryManagement;

import java.util.ArrayList;

public class ProductManagement {
	static Scanner sc= new Scanner(System.in);

	private static List<Product> list = new ArrayList<Product>();

	public static List<Product> getList() {
		return list;
	}

	public static void setList(List<Product> list) {
		ProductManagement.list = list;
	}
	public static int  autoId = 1; 
	public static void init() {
		list.add(new Product(autoId++, 1, "TiVi Sony", 12000000, 10));
		list.add(new Product(autoId++, 2, "Noi chien khong dau Philips", 6000000, 30));
		list.add(new Product(autoId++, 3, "Quan bo nu nhap khau", 300000, 100));
		list.add(new Product(autoId++, 1, "Tu Lanh Samsung", 15000000, 5));
		list.add(new Product(autoId++, 2, "Noi com Cockoo", 700000, 20));
	}
	public static void productUpdate() {
		do {
			System.out.println("\n--------CAP NHAT HANG HOA--------");
			System.out.println("Cac chuc nang cap nhat");
			System.out.println("\t1.Xem danh sach hang hoa");
			System.out.println("\t2.Them mot hang hoa moi vao danh sach");
			System.out.println("\t3.Sua thong tin  hang trong danh sach");
			System.out.println("\t4.Xoa mot hang hoa trong danh sach");
			System.out.println("\t0.Quay lai");
			
			System.out.print("Lua chon chuc nang cap nhat: ");
			int chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1: display(); break;
			case 2: add();break;
			case 3: edit();break;
			case 4: remove();break;
			case 0: break;
			default:System.out.println("Lua chon khong hop le");
			}
		} while (true);
	}
	
	private static void remove() {
		System.out.println("\n-------XOA THONG TIN HANG HOA-------");
		System.out.println("\tNhap id hang hoa: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = indexOfProduct(id);
		if (index == -1) {
			System.out.println("\tHang hoa khong tin tai trong danh sach");
			return;
		}
		list.remove(index);
		System.out.println("\tXoa hang hoa thanh cong!");
	}

	private static void edit() {
		System.out.println("\n--------SUA THONG TIN HANG HOA--------");
		System.out.println("\tNhap id loai hang: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = indexOfProduct(id);
		if (index ==-1) {
			System.out.println("\tHang hoa khong ton tai trong danh sach");
			return;
		}
//		Co  trong ds thi ta sua
		do {
			System.out.println("\n--------SUA THONG TIN HANG HOA--------");
			System.out.println("Chon thong tin can sua");
			System.out.println("\t1. Sua ma(id) loai hang ");
			System.out.println("\t2. Sua ten hang hoa ");
			System.out.println("\t3. Sua  so luong hang hoa");
			System.out.println("\t4. Sua dom gia hang hoa");
			System.out.println("\t0. Quay lai");
			
			System.out.println("Lua chon cua ban?");
			int chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1: 
				System.out.println("\tChon ctegory id: ");
				int categoryId =Integer.parseInt(sc.nextLine());
//				Kiem tra categoryId vua nhapp co trong ds categoryes khong?
				if (CategoryManagement.indexOfCategory(categoryId)== -1) {
					System.out.println("\tChon category id khong hop le");
					return;
				}
				list.get(index).setCategoryId(categoryId);
				System.out.println("\tSua ma loai hang thanh cong!");
				break;
			case 2: 
				System.out.print("\tNhap ten hang hoa: ");
				String name = sc.nextLine();
				if (name == null || name.trim().length() == 0) {
					System.out.println("\tTen loai hang khong duoc de trong");
					return;
				}
				list.get(index).setName(name);
				System.out.println("\tSua ten hang hoa thanh cong!");
				break;
			case 3: 
				System.out.print("\tNhap so/khoi luong: ");
				double amount = Double.parseDouble(sc.nextLine());
				if (amount <0) {
					System.out.println("\tSo/khoi luong khong duoc la so am");
				   return; 
				}
				list.get(index).setAmount(amount);
				break;
			case 4:
				System.out.print("\tNhap don gia: ");
				double price = Double.parseDouble(sc.nextLine());
				if (price <0) {
					System.out.println("\tDon gia khong duoc la so am");
				   return;
				}
				list.get(index).setPrice(price);
				System.out.println("\tSua don gia thanh cong!");
				break;
			case 0: return;
			default: System.out.println("Lua chon khong hop le");
			}
		} while (true);
		
	}

	private static void add() {
		System.out.println("\n-------THEM HANG HOA MOI VAO DANH SACH HANG HOA--------");
		System.out.println("\tChon ctegory id: ");
		int categoryId =Integer.parseInt(sc.nextLine());
//		Kiem tra categoryId vua nhapp co trong ds categoryes khong?
		if (CategoryManagement.indexOfCategory(categoryId)== -1) {
			System.out.println("\tChon category id khong hop le");
			return;
		}
		 
		System.out.print("\tNhap ten hang hoa: ");
		String name = sc.nextLine();
		if (name == null || name.trim().length() == 0) {
			System.out.println("\tTen loai hang khong duoc de trong");
			return;
		}
		System.out.print("\tNhap don gia: ");
		double price = Double.parseDouble(sc.nextLine());
		if (price <0) {
			System.out.println("\tDon gia khong duoc la so am");
		   return;
		}
		System.out.print("\tNhap so/khoi luong: ");
		double amount = Double.parseDouble(sc.nextLine());
		if (price <0) {
			System.out.println("\tSo/khoi luong khong duoc la so am");
		   return; 
		} 
		
//		Them hang hoa moi vao danh sach
		list.add(new Product(autoId++, categoryId, name, price, amount));
		System.out.println("\tThem hang hoa moi thanh cong!");
		
		
	}

	private static void display() {
		System.out.println("\n-------DANH SACH HANG HOA--------");
		System.out.printf("%6s %-25s %-30s %-15s %-12s%n","ID", "Ten loai hang",
				"Ten hang hoa","Don gia", "So Luong");
		for (Product product : list) {
			product.display();
		}
		
	}

	public static int indexOfProduct(int id) {
		for (int index = 0; index < list.size(); index++) {
			if (list.get(index).getId() == id) {
				return index;
			}
		}
		return -1;
	}
//	Ham tra ve doi tuong hang hoa
	public static Product getProductByIf(int id) { 
		for (Product product : list) {
			return product;
		}
		return null;
	}
	
	
}
