package posTest;

public class DrinkObject extends Object {

	// Data Stored

	private String drinkName,syrName,Size,milkName;

	private double price;

	DrinkObject() {
		drinkName = "";
		price = 0.0;
	}

	public String getDrinkName() {
		return Size + "/" + milkName  + "/" +  syrName  + "/" +  drinkName;
	}

	public void addToDrinkItem(String d) {

		if (this.drinkName.equals("")) {
			this.drinkName = d;
		} else {
			this.drinkName = this.drinkName + "" + d;
		}
		this.drinkName = this.drinkName.replace("\n ", "");
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
	
	public String getSyrName() {
		return syrName;
	}

	public void setSyrName(String syrName) {
		this.syrName = syrName;
	}

	public String getSize() {
		return Size;
	}

	public void setSize(String size) {
		Size = size;
	}

	public String getMilkName() {
		return milkName;
	}

	public void setMilkName(String milkName) {
		this.milkName = milkName;
	}
}