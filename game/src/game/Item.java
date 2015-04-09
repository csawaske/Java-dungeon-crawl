package game;

public class Item {
	
	public String itemName;
	public String modifierType = "fire";
	boolean weaponMod = true;
	boolean armorMod = true;
	
	public Item(String name) {
		itemName = name;
	}
	
	public String toString() {
		return "item";
	}
	
}
