package HotelManagementSystem;

import java.util.ArrayList;

public class Customer {
	// Attributes
	private String name;
	private double discount;
	private String status;
	private ArrayList<Room> bookedRooms = new ArrayList<Room>();

	// Default Constructor
	public Customer() {
		this.name = "unknown";
		this.discount = 0.0;
		this.status = "";
	}

	// Parameterized Constructor
	public Customer(String aName, String aStatus) {
		this.name = aName;
		this.status = aStatus;
		this.setDiscount(aStatus);
	}

	// Getter Methods
	public String getName() {
		return this.name;
	}

	public double getDiscount() {
		return this.discount;
	}

	public String getStatus() {
		return this.status;
	}

	// Setter Methods
	public void setName(String aName) {
		this.name = aName;
	}

	public void setDiscount(String aStatus) {
		this.status = aStatus;
		switch (this.status.toUpperCase()) {
		case "ACTIVE":
			this.discount = 0.10;
			break;

		case "VIP":
			this.discount = 0.05;
			break;

		case "NEW":
			this.discount = 0.0;
			break;

		default:
			break;
		}
	}

	// Methods to manage booked rooms
	public void addBookedRoom(Room room) {
		this.bookedRooms.add(room);
	}

	public ArrayList<Room> getAllBookedRooms() {
		return this.bookedRooms;
	}

	// toString Method
	public String toString() {
		return "Name: " + this.name + "\tStatus: " + this.status + "\tDiscount: "
				+ String.format("%.0f", discount * 100) + "%";
	}
}
