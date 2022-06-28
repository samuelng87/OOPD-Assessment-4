package HotelManagementSystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

// The main class which has main logic.
public class HotelDriver {
	// Main logic
	public static void main(String[] args) {
		// Create room objects.
		ArrayList<Room> rooms = createRooms();

		// Create amenities objects.
		ArrayList<Amenities> amenities = createAmenities();

		// Display welcome message.
		displayWelcomeMessage();

		// Declaration and initialising.
		Scanner sc = new Scanner(System.in);
		final String yes = "YES";
		final String endService = "Thank you for using our service good bye";

		System.out.println("Would you like to try our hotel booking? Please choose: YES/NO");
		String answer = sc.next();

		// Ask user if they want to place order. If yes, ask the name and status of customer and save
		// it because you will need it for calculating the final price and printing the final output.
		if (yes.equals(answer.toUpperCase())) {
			Customer customer = createCustomerInfo();

			do {
				// Display all created room types and ask user to enter the room they want to book using room ID.
				for (Room room : rooms) {
					System.out.println(room);
					System.out.println();
				}

				Room customerSelectedRoom = null;
				int customerSelectedRoomId = 0;
				System.out.println("\nPlease Choose the Available Rooms by Entering the Room ID: Example - ID:1011 ");

				do {
					customerSelectedRoomId = sc.nextInt();
					for (int i = 0; i < rooms.size(); i++) {
						Room room = rooms.get(i);
						if (room.getID() == customerSelectedRoomId) {
							System.out.println("You have selected:\n" + room);
							customerSelectedRoom = room;
							break;
						}
					}
					if (customerSelectedRoom == null) {
						System.out.println("choose again");
					}
				} while(customerSelectedRoom == null);

				// Pupulate each room with all selected amenities.
				System.out.println("\nPlease Choose the Available Amenities by Entering the Amenity ID: Example - ID:1 ");
				System.out.println("Enter 0 to finish adding amenities.");
				for (Amenities amenity : amenities) {
					System.out.println(amenity);
				}
				int customerSelectedAmenityId = 0;
				do {
					customerSelectedAmenityId = sc.nextInt();
					Amenities customerSelectedAmenity = null;
					for (Amenities amenity : amenities) {
						if (amenity.getID() == customerSelectedAmenityId) {
							customerSelectedAmenity = amenity;
							System.out.println("You have selected " + customerSelectedAmenity.getName());
							break;
						}
					}
					if (customerSelectedAmenity != null) {
						customerSelectedRoom.addAmenity(customerSelectedAmenity);
					} else if (customerSelectedAmenityId != 0) {
						System.out.println("ERROR!!!! Please Select bewteen 0 to " + amenities.size());
					}
				} while(customerSelectedAmenityId != 0);
				customer.addBookedRoom(customerSelectedRoom);

				System.out.println("Would you like to book more room? Please choose: YES/NO");
				answer = sc.next();
			} while(yes.equals(answer.toUpperCase()));

			// Display all prices.
			double totalAllRoomsPrice = 0;
			double totalAmenitiesPrice = 0;
			for (Room room : customer.getAllBookedRooms()) {
				room.setPrice();
				totalAllRoomsPrice += room.getPrice();
				totalAmenitiesPrice += room.calculateTotalAmenitiesPrice();
			}
			double totalAmountOfPrice = (totalAllRoomsPrice + totalAmenitiesPrice) * (1 - customer.getDiscount());
			System.out.println();
			System.out.println("Total of all room price: " + totalAllRoomsPrice);
			System.out.println("Total of amenities price: " + totalAmenitiesPrice);
			System.out.println("Total amount of price:" + totalAmountOfPrice);

			// Display order details and unpaid charges.
			System.out.println();
			System.out.println("Order details");
			for (Room room : customer.getAllBookedRooms()) {
				System.out.println(room);
				for (Amenities amenity : room.retriveAmenities()) {
					System.out.println(amenity);
				}
				System.out.println();
			}
			// Unpaid charges
			System.out.println("Unpaid charges: " + totalAmountOfPrice);

		} else {
			System.out.println(endService);
		}
	}

	//  Create Rooms list.
	public static ArrayList<Room> createRooms() {
		ArrayList<Room> rooms = new ArrayList<Room>();
		rooms.add(new DeluxeQueen(1011, "Deluxe Queen Room", 200, " 10 floor, No.11", "Moutain View"));
		rooms.add(new DeluxeQueen(1012, "Deluxe Queen Room", 200, " 10 floor, No.12", "Sea View"));
		rooms.add(new DeluxeQueenTwo(8011, "Deluxe Queen Two Room", 250, "80 floor, No.11", "Cloud View"));
		rooms.add(new DeluxeQueenTwo(8012, "Deluxe Queen Two Room", 250, "80 floor, No.12", "City View"));
		rooms.add(new DeluxeSpa(3011, "Deluxe Spa Room", 300, "30 floor, No.11", "Beach View & Spa facility"));
		rooms.add(new DeluxeSpa(3012, "Deluxe Spa Room", 300, "30 floor, No.12", "Casino View & Spa facility"));
		rooms.add(new FamilySuite(5011, "Deluxe Queen Room", 350, "50 floor, No.11", "Moutain View"));
		rooms.add(new FamilySuite(5012, "Deluxe Queen Room", 350, "50 floor, No.12", "Moutain View"));
		rooms.add(new FamilySuiteTwo(9911, "Deluxe Queen Room", 400, "99 floor, No.11", "Moutain View"));
		rooms.add(new FamilySuiteTwo(9912, "Deluxe Queen Room", 400, "99 floor, No.12", "Moutain View"));

		return rooms;
	}

	//  Create Amenities list.
	public static ArrayList<Amenities> createAmenities() {
		ArrayList<Amenities> amenities = new ArrayList<Amenities>();
		amenities.add(new Amenities(1, "Free WIFI", "(FREE) ", 0));
		amenities.add(new Amenities(2, "TV with Netflix", "(FREE)", 0));
		amenities.add(new Amenities(3, "Laundry containing washer and dryer", "(CHARGE)", 5));
		amenities.add(new Amenities(4, "Air Conditioner", "(FREE)", 0));
		amenities.add(new Amenities(5, "Heater", "(FREE)", 0));
		amenities.add(new Amenities(6, "Coffee machine", "(FREE)", 0));
		amenities.add(new Amenities(7, "Breakfast", "(FREE)", 0));
		amenities.add(new Amenities(8, "Lunch", "(CHARGE)", 15));
		amenities.add(new Amenities(9, "Dinner", "(CHARGE)", 20));
		amenities.add(new Amenities(10, "Undercover barbeque area", "(CHARGE)", 50));
		amenities.add(new Amenities(11, "Electric Blankets", "(CHARGE)", 10));
		amenities.add(new Amenities(12, "Toasters", "(FREE)", 0));
		amenities.add(new Amenities(13, "Microwave", "(FREE)", 0));

		return amenities;
	}

	// Printing the welcome message.
	public static void displayWelcomeMessage() {
		// Declaration and initializing.
		Date date = java.util.Calendar.getInstance().getTime();

		// Display the welcome message.
		displayStars();
		System.out.println("WELCOME TO WELCOME TO HOTEL MANAGEMENT SYSTEM\n");
		System.out.println("Developed by Koki Nakamura and Samuel Ng, Student IDs: K200885 and K210032");
		System.out.println("OODP101 Object Oriented Design and Programming Assessment Task 4");
		System.out.println(date + "\n");
		displayStars();
	}

	// Printing star line.
	public static void displayStars() {
		for (int i = 0; i < 100; i++) {
			System.out.print("*");
		}
		System.out.println("\n");
	}

	// Prompt the user to enter information then create a Customer object.
	public static Customer createCustomerInfo() {
		Scanner sc = new Scanner(System.in);
		String customerName;
		int customerStatusIndex;
		String customerStatus = "";

		// enter customer informaiton
		System.out.println("Please provide me your name");
		customerName = sc.next();

		System.out.println("Greetings " + customerName + "! May i have your status please? Choose a number:\n"
				+ "\n1.NEW" + "\n" + "2.ACTIVE" + "\n" + "3.VIP");
		customerStatusIndex = sc.nextInt();

		while (customerStatusIndex <= 0 || customerStatusIndex > 3) {
			System.out.println("ERROR!!!! Please Select bewteen 1 to 3");
			customerStatusIndex = sc.nextInt();
		}

		if (customerStatusIndex == 1) {
			customerStatus = "NEW";
			System.out.println(
					"Thank you " + customerName + " for using our service, here are the available rooms:\n");

		} else if (customerStatusIndex == 2) {
			customerStatus = "ACTIVE";
			System.out.println("Hi " + customerName
					+ "! Glad to see you using our service again! This are our available rooms with discount given:\n");

		} else if (customerStatusIndex == 3) {
			customerStatus = "VIP";
			System.out.println("Dear " + customerName
					+ ", It's an honour to serve you again. We always priorities the best room and generous discounts for you:\n");
		}
		return new Customer(customerName, customerStatus);
	}
}