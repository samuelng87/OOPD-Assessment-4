package HotelManagementSystem;

// This class is expressing a singular amenity class,
// but the assessment brief discuss implement "Amenities" class,
// so we implemented this class name in plural form.
public class Amenities {
	// Attributes
	private int id;
	private String name;
	private String description;
	private double price;

	// Default Constructor
	public Amenities() {
		this.id = 0;
		this.name = "unknown";
		this.description = "unknown";
		this.price = 0.0;
	}

	// Parameterized Constructor
	public Amenities(int anID, String aName, String aDescription, double aPrice) {
		this.id = anID;
		this.name = aName;
		this.description = aDescription;
		this.price = aPrice;
	}

	// Getter Methods
	public int getID() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	public double getPrice() {
		return this.price;
	}

	// Setter Methods
	public void setID(int anID) {
		this.id = anID;
	}

	public void setName(String aName) {
		this.name = aName;
	}

	public void setDescription(String aDescription) {
		this.description = aDescription;
	}

	public void setPrice(double aPrice) {
		this.price = aPrice;
	}

	// toString Method
	public String toString() {
		return "ID: " + this.id + "\tName: " + this.name + "\tPrice: " + this.price + "\tDescription: "
				+ this.description;
	}
}
