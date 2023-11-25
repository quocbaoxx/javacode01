package vn.devpro.storemanagement.update.costomer;

import java.util.ArrayList;
import java.util.Scanner;


public class CustomerManagement {
	private static ArrayList<Customer> list = new ArrayList<Customer>();

	public static ArrayList<Customer> getList() {
		return list;
	}

	public static void setList(ArrayList<Customer> list) {
		CustomerManagement.list = list;
	}
	
	public static int autoId = 1; // auto increasement
	
	public static void init() { //Để test các chức năng tránh phải nhập nhiều
		list.add(new Customer(autoId++, "Quach Tinh"));
		list.add(new Customer(autoId++, "Hoang Dung"));
		list.add(new Customer(autoId++, "Hong That Cong"));
		list.add(new Customer(autoId++, "Au Duong Phong"));
		list.add(new Customer(autoId++, "Mai Sieu Phong"));
	}
	
	static Scanner sc = new Scanner(System.in);
	
	public static void customerUpdate() {
		do {
			System.out.println("\n-------------CAP NHAT THONG TIN KHACH HANG-------------");
			System.out.println("Cac chuc nang cap nhat");
			System.out.println("\t1. Xem danh sach khach hang");
			System.out.println("\t2. Them mot khach hang moi vao danh sach");
			System.out.println("\t3. Sua thong tin khach hang trong danh sach");
			System.out.println("\t4. Xoa mot khach hang trong danh sach");
			System.out.println("\t0. Quay lai");
			
			System.out.print("Lua chon chuc nang cap nhat: ");
			int chon = Integer.parseInt(sc.nextLine());
			
			switch (chon) {
			case 1: display(); break;
			case 2: add(); break;
			case 3: edit(); break;
			case 4: remove(); break;
			case 0: return;
			default: System.out.println("Lua chon khong hop le");
			}
		}
		while (true);
	}

	private static void display() {
		System.out.println("\n\tDANH SACH khach hang");
		System.out.printf("%-5s %-30s%n", "Id", "Name");
		for (Customer Customer : list) {
			Customer.display();
		}
	}

	private static void add() {
		System.out.println("\n-------THÊM MỘT khách hang MỚI VÀO DANH SÁCH-----------");
		System.out.print("\tNhap ten khach hang: ");
		String name = sc.nextLine();
		if (name == null || name.trim().length() == 0) {
			System.out.println("\tTen khach hang khong duoc de trong");
			return;
		}
		
		//Them vao danh sach
		//+ Tao mot doi tuong Customer moi
		Customer newCustomer = new Customer(autoId++, name);
		//+ Them vao danh sach
		list.add(newCustomer);
		System.out.println("\tThem moi khach hang thanh cong!");
	}

	private static void edit() {
		System.out.println("\n--------SUA THONG TIN KHACH HANG------------");
		System.out.print("\tNhap id khach hang: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = indexOfCustomer(id);
		if (index == -1) {
			System.out.println("\tkhach hang khong ton tai trong danh sach");
			return;
		}
		//Co trong ds thi ta sua
		System.out.print("\tNhap ten khach hang: ");
		String name = sc.nextLine();
		if (name == null || name.trim().length() == 0) {
			System.out.println("\tTen khach hang khong duoc de trong");
			return;
		}
		
		//Thay the ten cu bang ten moi
		list.get(index).setName(name);
		System.out.println("\tSua ten khach hang thanh cong");
	}

	private static void remove() {
		System.out.println("\n--------XOA THÔNG TIN khách hang------------");
		System.out.print("\tNhap id khach hang: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = indexOfCustomer(id);
		if (index == -1) {
			System.out.println("\tkhach hang khong ton tai trong danh sach");
			return;
		}
		//Co trong ds thi ta XOA
		list.remove(index);
		System.out.println("\tXoa khach hang thanh cong");
	}
	
	private static boolean nameIsExist(String name) {
		for (Customer customer : list) {
			if (customer.getName().trim().equalsIgnoreCase(name.trim())) {
				return true;
			}
		}
		return false;
	}
	
	public static int indexOfCustomer(int id) {
		for (int index = 0; index < list.size(); index++) {
			if (list.get(index).getId() == id) {
				return index;
			}
		}
		return -1;
	}
	
	public static String getNameById(int id) {
		for (Customer customer : list) {
			if (customer.getId() == id) {
				return customer.getName();
			}
		}
		return null;
	}


}
