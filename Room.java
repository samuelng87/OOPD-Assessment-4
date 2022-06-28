package HotelManagementSystem;

import java.util.ArrayList;

public class Room {
	// Attributes
	private int id;
	private String features;
	private double price;
	private String location;
	private ArrayList<Amenities> amenitiesList;

	// Default Constructor
	public Room() {
		this.id = 0;
		this.features = "unknown";
		this.price = 0.0;
		this.location = "unknown";
		this.amenitiesList = new ArrayList<Amenities>();
	}

	// Parameterized Constructor
	public Room(int anID, String aFeatures, double aPrice, String aLocation) {
		this.id = anID;
		this.features = aFeatures;
		this.price = aPrice;
		this.location = aLocation;
		this.amenitiesList = new ArrayList<Amenities>();
	}

	// Getter Methods
	public int getID() {
		return this.id;
	}

	public String getFeatures() {
		return this.features;
	}

	public double getPrice() {
		return this.price;
	}

	public String getLocation() {
		return this.location;
	}

	// Setter Methods
	public void setID(int anID) {
		this.id = anID;
	}

	public void setFeatures(String aFeatures) {
		this.features = aFeatures;
	}

	// To implement in subclasses.
	public void setPrice() {
	}

	public void setPrice(double aPrice) {
		this.price = aPrice;
	}

	public void setLocation(String aLocation) {
		this.location = aLocation;
	}

	// Methods to operate amenities list
	public void addAmenity(Amenities amenities) {
		this.amenitiesList.add(amenities);
	}

	public Amenities retriveAmenity(int id) {
		for (Amenities amenities : this.amenitiesList) {
			if (amenities.getID() == id) {
				return amenities;
			}
		}

		return null;
	}

	public ArrayList<Amenities> retriveAmenities() {
		return this.amenitiesList;
	}

	public void removeAmenities() {
		this.amenitiesList.clear();
	}

	public double calculateTotalAmenitiesPrice() {
		double price = 0.0;
		for (Amenities amenities : this.amenitiesList) {
			price += amenities.getPrice();
		}

		return price;
	}

	// Override toString Method
	public String toString() {
		return "ID:" + this.getID() + "\nType:" + this.getFeatures() + "\nLocation:" + this.getLocation() + "\nPrice:"
				+ this.getPrice();
	}
}
