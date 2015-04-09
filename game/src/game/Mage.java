package game;
import java.io.*;

public class Mage extends Character {
	
	public Mage(String name) throws FileNotFoundException {
		characterName = name;
		weapons.add(new Weapon("Flame Sword", "HellBreaker"));
		armor.add(new Armor("Loincloth"));
		stats = new int[] {5, 5, 8, 10};
	}

}
