package posTest;

public class DrinkObject extends Object {

	// Data Stored

	private String drinkName;
	private double price;

	DrinkObject() {
		drinkName = "";
		price = 0.0;
	}

	public String getDrinkName() {
		return drinkName;
	}

	public void addToDrinkItem(String d) {

		if (this.drinkName.equals("")) {
			this.drinkName = d;
		} else {
			this.drinkName = this.drinkName + "" + d;
		}
		this.drinkName = this.drinkName.replace(" ", "");
	}

	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}