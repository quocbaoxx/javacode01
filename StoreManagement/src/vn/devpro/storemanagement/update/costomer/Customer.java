package vn.devpro.storemanagement.update.costomer;

public class Customer {
	private int id ;
	private String name;
	
	
	public void display() {
		System.out.printf("%-5d %-30s%n", this.id, this.name);
	}


	public Customer(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public Customer() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
}
