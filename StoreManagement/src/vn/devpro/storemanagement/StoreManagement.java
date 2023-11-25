package vn.devpro.storemanagement;

import java.util.Scanner;

import vn.devpro.storemanagement.sale.CartManagement;
import vn.devpro.storemanagement.saleoder.SaleOderManagement;
import vn.devpro.storemanagement.update.SystemInformationManagement;
import vn.devpro.storemanagement.update.category.CategoryManagement;
import vn.devpro.storemanagement.update.costomer.CustomerManagement;
import vn.devpro.storemanagement.update.product.ProductManagement;

public class StoreManagement {
static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		CategoryManagement.init();
		ProductManagement.init();
		CustomerManagement.init();
		do {
			System.out.println("\t--------CHUONG TRINH QUAN LY CUA HANG--------");
			System.out.println("Cac chuc nang quan ly chinh");
			System.out.println("\t1.Cap nhat thong tin he thong");
			System.out.println("\t2.Quan ly ban hang");
			System.out.println("\t3.Quan ly don hang");
			System.out.println("\t0.Thoat"); 
			
			System.out.print("Lua chon chuc nang quan ly!");
			int chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1: SystemInformationManagement.execute(); break;
			case 2: CartManagement.cartManagement(); break;
			case 3: SaleOderManagement.saleOrderManagement(); break;
			case 0: System.out.println("Thoat khoi ung dung");
			System.exit(0);
			default: System.out.println("Lua chon khong hop le");
			}	
		} while (true);

	}

}
