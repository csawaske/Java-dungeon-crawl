package game;

import java.awt.Color;
import java.awt.Point;
import java.io.FileNotFoundException;

public class SamplePlayer extends Character{

	public SamplePlayer(String name) throws FileNotFoundException {
		characterName = name;
		weapons.add(new Weapon("Iron Sword", "HellBreaker"));
		armor.add(new Armor("Loincloth"));
		position = new Point(150, 150);
		color = Color.RED;
		primaryWeapon = weapons.get(0);
		stringRep = name.substring(0, 1).toUpperCase();
	}
	
}
