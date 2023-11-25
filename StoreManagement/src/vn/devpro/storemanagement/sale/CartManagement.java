package vn.devpro.storemanagement.sale;

import java.util.Scanner;

import vn.devpro.storemanagement.saleoder.SaleOderManagement;
import vn.devpro.storemanagement.update.costomer.Customer;
import vn.devpro.storemanagement.update.costomer.CustomerManagement;

public class CartManagement {//Phien giao dich cua khach mua hang
	
//	Nhan mot gio hang - Khong tao gio hang
//	Khach hang thuc hien cac thao tac
//	 + Xem thong tin gio hang
//	 + Dua hang vao gio
//	 + Sua so luong
//	 + Xoa hang khoi gio
//	 + Thanh toan
//	 + Huyr gio hang
	public static int autoId = 1; // auto increasement
	static Scanner sc = new Scanner(System.in);
	public static void cartManagement() {
		Cart cart = new Cart(); //Khoi tao gio hang
		System.out.println("\n\tChao mung qua khach den mua hang");
		do {
			System.out.println("Chon thao tac voi gio hang cua ban");
			System.out.println("\t1. Xem thong tin gio hang");
			System.out.println("\t2. Them hang vao gio");
			System.out.println("\t3. Sua so luong hang trong gio");
			System.out.println("\t4.Xoa hang hoa khoi gio");
			System.out.println("\t5. Huy gio hang");
			System.out.println("\t6. Thanh toan gio hang");
			System.out.println("\t0. Thoat");
			
			System.out.print("Lua chon cua ban?");
			int chon = Integer.parseInt(sc.nextLine());
			
			switch (chon) {
			case 1:cart.display();break;
			case 2:cart.add(); break;
			case 3:cart.update(); break;
			case 4:cart.remove(); break;
			case 5:cart = new Cart(); break;
			case 6://Thanh toan gio hang
				if (payment(cart)== true) {//Thanh toan thanh cong
					cart = new Cart();//Xoa gio hang sau khi thanh toan
				}
				break;
			case 0:return;
			default:System.out.println("Lua chon cua ban khong hop le");
			}
		} while (true);
	}
	private static boolean payment(Cart cart) {
		if (cart== null||cart.getList().size() <= 0) {//gio chua co hang
			System.out.println("Ban chua mua hang");
			return false;
		}
		System.out.println("\n-------THANH TOAN GIO HANG--------");
//		Cap nhat thong tin khach hang
		System.out.println("Nhap ma id khach hang: ");
		int customerId= Integer.parseInt(sc.nextLine());
		
//		Kiem tra khach hang co trong danh sach hay chua
		int index = Integer.parseInt(sc.nextLine());
		String customerName = null;
		if (index ==-1) {//Khach hang chua co trong danh sach luu
			System.out.println("Nhap ho ten khach hang: ");
			customerName = sc.nextLine();
			if (customerName.length() <= 0) {
				System.out.println("Ten khach hang khong duoc de trong");
				return false;
				
			}
//			Them khach hang vao danh sach khach hang
			customerId =CustomerManagement.autoId++;
			CustomerManagement.getList().add(new Customer(customerId, customerName));
			
		}else {//Khach hang da co trong danh sach
			customerName = CustomerManagement.getList().get(index).getName();
			
		}
//		Cap nhat thong tin gio hang
		cart.setId(autoId++);
		cart.setCustomerId(customerId);
		//Hien thi lai gio hang cho khach xem
				cart.display();
				//Luu gio hang vao danh sach
				SaleOderManagement.getCarts().add(cart);
				
				//Xoa gio hang
				System.out.println("Thanh toan gio hang thanh cong!");
				return true;
	}
}
