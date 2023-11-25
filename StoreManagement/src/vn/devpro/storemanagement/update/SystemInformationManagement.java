package vn.devpro.storemanagement.update;

import java.util.Scanner;

import vn.devpro.storemanagement.update.category.CategoryManagement;
import vn.devpro.storemanagement.update.costomer.CustomerManagement;
import vn.devpro.storemanagement.update.product.ProductManagement;

public class SystemInformationManagement {
	static Scanner sc = new Scanner(System.in);

	public static void execute() {
		do {
			System.out.println("\t--------CAP NHAT THONG TIN HE THONG-------");
			System.out.println("Cac chuc nang cap nhat");
			System.out.println("\t1.Cap nhat thong tin loai hang");
			System.out.println("\t2.Cap nhat thong tin hang hoa");
			System.out.println("\t3.Cap nhat thong tin khach hang");
			System.out.println("\t0.Quay lai");
			
			System.out.print("Lua chon chuc nang quan ly!");
			int chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1: CategoryManagement.categoryUpdate(); break;
			case 2: ProductManagement.productUpdate(); break;
			case 3: CustomerManagement.customerUpdate(); break;
			case 0: return;
			default: System.out.println("Lua chon khong hop le");
			}
		} while (true);
		
}
}