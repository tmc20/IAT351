package posTest;

import java.util.ArrayList;
import posTest.DrinkObject;

public class OrderObject extends Object {

	// Drink Data
	private ArrayList<DrinkObject> drinkArray;

	OrderObject() {
		setDrinkArray(new ArrayList<DrinkObject>());
	}

	public void addDrinkToArray(DrinkObject d) {
		drinkArray.add(d);
	}

	public void removeDrinkFromArray() {
		// Removes Last Drink
		drinkArray.remove(drinkArray.size() - 1);
	}

	public void removeDrinkFromArray(int pos) {
		// Removes Number Drink
		drinkArray.remove(pos);
	}

	public DrinkObject getDrink(int i) {
		return drinkArray.get(i);
	}

	public ArrayList<DrinkObject> getDrinkArray() {
		return drinkArray;
	}

	public void setDrinkArray(ArrayList<DrinkObject> drinkArray) {
		this.drinkArray = drinkArray;
	}

	@Override
	public String toString() {
		String tempString = "";

		for (int i = 0; i < drinkArray.size() - 1; i++) {
			tempString += drinkArray.get(i).getDrinkName() + ", ";
		}

		return tempString;
	}
}