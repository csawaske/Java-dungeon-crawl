package game;

import inventory.Armor;
import inventory.TotalInventory;

public class Mage extends Character {
	
	public Mage(String name) {
		characterName = name;
		stringRep = name.substring(0, 1).toUpperCase();
		weapons.add(TotalInventory.getWeapon("Flame Sword"));
		armor.add(new Armor("Loincloth"));
		this.rightHand = weapons.get(0);
	}

}
