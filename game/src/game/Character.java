package game;
import java.util.*;

public class Character {
	
	public String characterName;
	public ArrayList<Item> inventory = new ArrayList<Item>();
	public ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	public ArrayList<Armor> armor = new ArrayList<Armor>();
	public int[] stats = new int[4];
	public int money = 100;
	
	
	public String toString() {
		return characterName;
	}
	
	public void showInventory() {
		for (int i = 0; i <inventory.size(); i++) {
			System.out.println(inventory.get(i).toString());
		}
	}

}
