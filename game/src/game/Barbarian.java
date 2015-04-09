package game;
import java.io.*;

public class Barbarian extends Character {
	
	public Barbarian(String name) throws FileNotFoundException {
		characterName = name;
		weapons.add(new Weapon("Iron Sword", "HellBreaker"));
		weapons.add(new Weapon("Flame Sword", "Ice Breaker"));
		armor.add(new Armor("Loincloth"));
		stats = new int[] {10, 10, 2, 2};
	}

}
