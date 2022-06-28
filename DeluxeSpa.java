package HotelManagementSystem;

public class DeluxeSpa extends Room {
	// Attributes
	private int surcharges = 50;
	private String description;

	// Default Constructor
	public DeluxeSpa() {
		super();
		this.description = "";
	}

	// Parameterized Constructor
	public DeluxeSpa(int anID, String aFeatures, double aPrice, String aLocation, String aDescription) {
		super(anID, aFeatures, aPrice, aLocation);
		this.description = aDescription;
	}

	// Getter Methods
	public int getSurchagres() {
		return surcharges;
	}

	public String getDescription() {
		return description;
	}

	// Setter Methods
	public void setSurchagres(int aSurcharges) {
		int roomSurcharges = 50 - aSurcharges;
		this.surcharges = roomSurcharges;
	}

	public void setDescription(String aDescription) {
		this.description = aDescription;
	}

	// Override Set Price Method
	public void setPrice() {
		super.setPrice(this.getPrice() + this.surcharges);
	}

	// Override toString Method
	public String toString() {
		return super.toString() + "\nFacing: " + this.description + "\nSurcharges $" + this.surcharges;
	}
}
