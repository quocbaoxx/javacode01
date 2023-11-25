package vn.devpro.storemanagement.saleoder;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

import vn.devpro.storemanagement.sale.Cart;
import vn.devpro.storemanagement.update.costomer.CustomerManagement;

public class SaleOderManagement {
	private static List<Cart> carts = new ArrayList<Cart>();

	public static List<Cart> getCarts() {
		return carts;
	}

	public static void setCarts(List<Cart> carts) {
		SaleOderManagement.carts = carts;
	}
	//Hien thi danh sach cac gio hang (cac don hang)
		//Tinh tong doanh thu tu cac gio hang
		//Tim k ien thi chi tiet gio hang neu tim thay
	static Scanner sc = new Scanner(System.in);
	public static void saleOrderManagement() {
		do {
			System.out.println("\n----------QUAN LY DON HANG-----------");
			System.out.println("Chon chuc nang quan ly");
			System.out.println("\t1. Hien thi danh sach don hang (gio hang)");
			System.out.println("\t2. Xem tong doanh thu tu cac don hang");
			System.out.println("\t3. Tim kiem don hang");
			System.out.println("\t0. Quay lai");
			
			System.out.print("Lua chon cua ban?: ");
			int chon = Integer.parseInt(sc.nextLine());
			
			switch (chon) {
			case 1: displayCarts(); break;
			case 2: displayTotalMoney(); break;
			case 3: searchCart(); break;
			case 0: return;
			default: System.out.println("Lua chon khong hop le");
			}
		} while (true);
		
	}

	private static void displayCarts() {
		System.out.println("---------danh sach cac don hang-----------");
		System.out.printf("%3s %11s %-30s %-15s%n", "STT", "Ma don hang", "Ten khach hang", "Tong tien hang");
		int stt = 1;
		for (Cart cart : carts) {
			System.out.printf("%3d %-11d %-30s %,15.2f%n", stt++, cart.getId(),
					CustomerManagement.getNameById(cart.getCustomerId()),
					cart.cartTotal());
		}
	}

	public static double totalMoney() {
		double total = 0;
		for (Cart cart : carts) {
			total += cart.cartTotal();
		}
		return total;
	}
	
	private static void displayTotalMoney() {
		System.out.printf("\nTong doan thu: %,.2f%n", totalMoney());
		
	}

	private static void searchCart() {
		System.out.println("\n-----------TIM KIEM DON HANG---------");
		System.out.print("Nhap ma don hang (id gio hang): ");
		int cartId = Integer.parseInt(sc.nextLine());
		boolean result = false;
		
		for (Cart cart : carts) {
			if (cart.getId() == cartId) {
				System.out.println("Chi tiet gio hang tim duoc");
				cart.display();
				result = true;
			}
		}
		
		if (result == false) {
			System.out.println("Khong tim thay ket qua nao");
		}
	}
}
