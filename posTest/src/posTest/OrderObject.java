package posTest;

import java.util.ArrayList;
import posTest.DrinkObject;

public class OrderObject extends Object {

	// Drink Data
	private ArrayList<DrinkObject> drinkArray;
	
	OrderObject(){
		setDrinkArray(new ArrayList<DrinkObject>());
	}
	
	public void addDrinkToArray(DrinkObject d) {
		drinkArray.add(d);
	}
	
	public void removeDrinkFromArray(){
		// Removes Last Drink
		drinkArray.remove(drinkArray.size()-1);
	}

	public void removeDrinkFromArray(int pos){
		// Removes Number Drink
		drinkArray.remove(pos);
	}
	
	public ArrayList<DrinkObject> getDrinkArray() {
		return drinkArray;
	}

	public void setDrinkArray(ArrayList<DrinkObject> drinkArray) {
		this.drinkArray = drinkArray;
	}
	
}
