package game;
import java.io.*;

public class Mage extends Character {
	
	public Mage(String name) throws FileNotFoundException {
		characterName = name;
		stringRep = name.substring(0, 1).toUpperCase();
		weapons.add(new Weapon("Flame Sword", "HellBreaker"));
		armor.add(new Armor("Loincloth"));
	}

}
