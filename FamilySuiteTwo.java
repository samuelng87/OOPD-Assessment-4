package HotelManagementSystem;

public class FamilySuiteTwo extends Room {
	// Attributes
	private double discount = 0.05;
	private String description;

	// Default Constructor
	public FamilySuiteTwo() {
		super();
		this.description = "";
	}

	// Parameterized Constructor
	public FamilySuiteTwo(int anID, String aFeatures, double aPrice, String aLocation, String aDescription) {
		super(anID, aFeatures, aPrice, aLocation);
		this.description = aDescription;
	}

	// Getter Methods
	public double getDiscount() {
		return discount;
	}

	public String getDescription() {
		return description;
	}

	// Setter Methods
	public void setDiscount(double aDiscount) {
		double roomDiscount = (0.05 * aDiscount) - aDiscount;
		this.discount = roomDiscount;
	}

	public void setDescription(String aDescription) {
		this.description = aDescription;
	}

	// Override Set Price Method
	public void setPrice() {
		super.setPrice(this.getPrice() * (1 - this.discount));
	}

	// Override toString Method
	public String toString() {
		return super.toString() + "\nFacing: " + this.description + "\nDiscount " + (this.discount * 100) + "%";
	}
}
