package vn.devpro.storemanagement.update.category;

import java.util.ArrayList;
import java.util.Scanner;

public class CategoryManagement {
	static Scanner sc= new Scanner(System.in);
	private static ArrayList<Category> list = new ArrayList<Category>();
	
//	Tao getter set ter khong can tao contructu
	public static ArrayList<Category> getList() {
		return list;
	}

	public static void setList(ArrayList<Category> list) {
		CategoryManagement.list = list;
	}
	public static int autoId = 1;//auto increasement
	
	public static void init() {//de test cac chuc nang tranh phai nhap nhieu
		list.add(new Category(autoId++, "Dien tu"));
		list.add(new Category(autoId++, "Gia dung"));
		list.add(new Category(autoId++, "Thoi trang"));
		list.add(new Category(autoId++, "My pham"));
		list.add(new Category(autoId++, "Thuc pham"));
	}
	public static void categoryUpdate() {
		do {
			System.out.println("\n--------CAP NHAT THONG TIN LOAI HANG--------");
			System.out.println("Cac chuc nang cap nhat");
			System.out.println("\t1.Xem danh sach loai hang");
			System.out.println("\t2.Them mot loai hang moi vao danh sach");
			System.out.println("\t3.Sua thong tin loai hang trong danh sach");
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
	private static void display() {
		System.out.println("\n\tDANH SACH LOAI HANG");
		System.out.printf("%-5s %-30s%n","ID","Name");
		for (Category x : list) {
			x.display();
		}
		
	}

	private static void add() {
		System.out.println("\t-------THEM MOT LOAI HANG MOI VAO DANH SACH-------");
		System.out.print("\tNhap ten loai hang: ");
		String name = sc.nextLine();
		if (name == null || name.trim().length() == 0) {
			System.out.println("\tTen loai hang khong duoc de trong");
			return; 
		}
//		Kiem tra ten loai hang moi khong trung voi ten loai hang da co trong danh sach
		if (nameIsExist(name)) {
			System.out.println("\tTen nay da ton tai trong danh sach");
			return;
		}
//		Them vao danh sach
//		+Tao mot doi tuong category moi
		Category newcategory = new Category(autoId++, name);
//		+Them vao danh sach
		list.add(newcategory);
		System.out.println("\tThem mot loai hang thanh cong!");
	}
	private static  void edit() {
		System.out.println("\n--------SUA THONG TIN LOAI HANG--------");
		System.out.println("\tNhap id loai hang: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = indexOfCategory(id);
		if (index ==-1) {
			System.out.println("\tLoai hang khong ton tai trong danh sach");
			return;
		} 
//		Co tong ds thi ta sua
		System.out.print("\tNhap ten loai hang: ");
		String name = sc.nextLine();
		if (name == null || name.trim().length() == 0) {
			System.out.println("\tTen loai hang khong duoc de trong");
			return;
		}
//		Kiem tra ten loai hang moi khong trung voi ten loai hang da co trong danh sach
		if (nameIsExist(name)) {
			System.out.println("\tTen nay da ton tai trong danh sach");
			return;
		}
//		Thay the ten cu bang ten moi
		list.get(index).setName(name);
		System.out.println("\tSua ten loai hang thanh cong");
		
	}
	private static void remove() {
		System.out.println("\n--------XOA THONG TIN LOAI HANG--------");
		System.out.println("\tNhap id loai hang: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = indexOfCategory(id);
		if (index ==-1) {
			System.out.println("\tLoai hang khong ton tai trong danh sach");
			return;
		}
//		Co trong danh sach thi ta xoa
		list.remove(index);
		System.out.println("\tXoa loai hang thanh cong");

	}
	public static boolean nameIsExist(String name) {
		for (Category category : list) {
			if (category.getName().trim().equalsIgnoreCase(name.trim())) {
				return true;
			}
			
		}
		return false;
	}
	public static int indexOfCategory(int id) {
		for (int index = 0; index < list.size(); index++) {
			if (list.get(index).getId() == id) {
				return index;
			}
		}
		return -1;
	}
	public static String getNameById(int id) {
		for (Category category : list) {
			if (category.getId() == id) {
				return category.getName();
			}
		}
		return null;
	}
	
}
