package HotelManagementSystem;

public class FamilySuite extends Room {
	// Attributes
	private double discount = 0.15;
	private String description;

	// Default Constructor
	public FamilySuite() {
		super();
		this.description = "";
	}

	// Parameterized Constructor
	public FamilySuite(int anID, String aFeatures, double aPrice, String aLocation, String aDescription) {
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
		double roomDiscount = (0.15 * aDiscount) - aDiscount;
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
